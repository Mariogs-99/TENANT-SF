package sv.mh.fe.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import javax.validation.Valid;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import sv.mh.fe.business.CertificadoBusiness;
import sv.mh.fe.business.FirmarDocumentoBusiness;
import sv.mh.fe.constantes.Constantes;
import sv.mh.fe.constantes.Errores;
import sv.mh.fe.constantes.Errores.errores;
import sv.mh.fe.filter.FirmarDocumentoFilter;
import sv.mh.fe.models.CertificadoMH;
import sv.mh.fe.validations.FirmarDocumentoValidations;

@RestController
@RequestMapping("/firmardocumento")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FirmarDocumentoController extends Controller {

	final static Logger logger = LoggerFactory.getLogger(FirmarDocumentoController.class);

	@Autowired
	private CertificadoBusiness certificadoBusiness;

	@Autowired
	private FirmarDocumentoBusiness business;

	@Autowired
	private FirmarDocumentoValidations validation;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> firmar(@Valid @RequestBody FirmarDocumentoFilter filter) {
		CertificadoMH certificado = null;
		try {
			validation.v5validar(filter);
			if (!validation.isValido()) {
				return ResponseEntity.ok(mensaje.error(errores.COD_809_DATOS_REQUERIDOS, validation.getRequeridos()));
			}

			//? Convertir DTE JSON a String y leer el NIT desde "emisor"
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String dteString = ow.writeValueAsString(filter.getDteJson());
			JSONObject dteObject = new JSONObject(dteString);

			String nit = dteObject.getJSONObject("emisor").getString("nit");
			if (nit == null || nit.isEmpty()) {
				return ResponseEntity.ok(mensaje.error("NIT requerido para procesar firma."));
			}

			//? Verificar existencia del archivo .crt
			Path path = Paths.get(Constantes.DIRECTORY_UPLOADS, nit + ".crt");
			if (!Files.exists(path)) {
				return ResponseEntity.ok(mensaje.error("No se encontró el certificado para el NIT: " + nit));
			}

			//? Setear el NIT en el filter para que lo use CertificadoBusiness
			filter.setNit(nit);

			//? Recuperar el certificado
			certificado = certificadoBusiness.recuperarCertifiado(filter);
			if (certificado == null) {
				return ResponseEntity.ok(mensaje.error(Errores.COD_803_ERROR_LLAVE_PRUBLICA));
			}

			//? Firmar DTE
			logger.info("dteObject != null");
			System.out.println("JSON antes de firmar: " + dteString);
			String firma = business.firmarJSON(certificado, dteString);
			System.out.println("JSON después de firmar: " + firma);

			return ResponseEntity.ok(mensaje.ok(firma));

		} catch (JsonProcessingException e) {
			logger.info(errores.COD_810_CONVERTIR_JSON_A_STRING, e.getMessage());
			return ResponseEntity.ok(mensaje.error(Errores.COD_810_CONVERTIR_JSON_A_STRING));
		} catch (IOException e) {
			logger.error(e.getMessage());
			return ResponseEntity.ok(mensaje.error(errores.COD_812_NO_FILE, e.getMessage()));
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
			return ResponseEntity.ok(mensaje.error(errores.COD_804_ERROR_NO_CATALOGADO, e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.ok(mensaje.error(String.valueOf(Errores.COD_804_ERROR_NO_CATALOGADO), e.getMessage()));
		}

    }

	@GetMapping("/status")
	public String getStatus() {
		return "Application is running...!!";
	}
}
