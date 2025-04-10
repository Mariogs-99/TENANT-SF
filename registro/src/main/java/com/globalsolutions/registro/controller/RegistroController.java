package com.globalsolutions.registro.controller;

import com.globalsolutions.registro.model.RegistroClienteRequest;
import com.globalsolutions.registro.service.impl.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
@CrossOrigin(origins = "*") // Para permitir que el frontend acceda
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @PostMapping
    public ResponseEntity<?> registrarCliente(@RequestBody RegistroClienteRequest request) {
        try {
            registroService.procesarRegistro(request);
            return ResponseEntity.ok("Empresa registrada y base creada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
