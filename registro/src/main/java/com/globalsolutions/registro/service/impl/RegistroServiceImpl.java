// RegistroServiceImpl.java
package com.globalsolutions.registro.service.impl;

import com.globalsolutions.registro.model.MasterCompany;
import com.globalsolutions.registro.model.MasterUser;
import com.globalsolutions.registro.repository.MasterCompanyRepository;
import com.globalsolutions.registro.repository.MasterUserRepository;
import com.globalsolutions.registro.model.RegistroClienteRequest;
import com.globalsolutions.registro.service.impl.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Random;

@Service
public class RegistroServiceImpl implements RegistroService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_ADMIN_USER = "root";
    private static final String DB_ADMIN_PASS = "rootpass"; // ← cambialo por el real

    @Autowired
    private MasterCompanyRepository masterCompanyRepository;

    @Autowired
    private MasterUserRepository masterUserRepository;

    @Override
    public void procesarRegistro(RegistroClienteRequest request) throws Exception {
        String nombreEmpresa = request.getNombreEmpresa();
        String nit = request.getNit();
        String correo = request.getCorreoContacto();
        String telefono = request.getTelefono();

        // 1. Generar usuario DB
        String usuarioDB = generarUsuarioDB(nombreEmpresa);
        String nombreBD = "empresa_" + usuarioDB.toLowerCase();
        String passwordDB = generarPasswordSegura();

        // 2. Crear base de datos
        crearBaseDeDatos(nombreBD);

        // 3. Crear usuario de base de datos y asignar permisos
        crearUsuarioDB(usuarioDB, passwordDB, nombreBD);

        // 4. Ejecutar script SQL (pendiente)
        ejecutarScriptSQL(nombreBD);

        // 5. Registrar en master_company
        MasterCompany company = MasterCompany.builder()
                .nameCompany(nombreEmpresa)
                .emailCompany(correo)
                .phoneCompany(telefono)
                .nit(nit)
                .databaseUrl("jdbc:mysql://localhost:3308/" + nombreBD)
                .databaseUsername(usuarioDB)
                .databasePassword(passwordDB)
                .active(true)
                .newCompany(1)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        MasterCompany savedCompany = masterCompanyRepository.save(company);

        // 6. Registrar en master_user
        MasterUser adminUser = MasterUser.builder()
                .usuario("admin")
                .clave("admin123") // En producción, encriptar esto con BCrypt
                .company(savedCompany)
                .build();

        masterUserRepository.save(adminUser);
    }

    private String generarUsuarioDB(String nombreEmpresa) {
        String letras = nombreEmpresa.replaceAll("[^A-Za-z]", "").toUpperCase(Locale.ROOT);
        String iniciales = letras.length() >= 2 ? letras.substring(0, 2) : letras;
        int numero = new Random().nextInt(9000) + 1000;
        return iniciales + numero;
    }

    private String generarPasswordSegura() {
        return "P@ss" + new Random().nextInt(9999);
    }

    private void crearBaseDeDatos(String nombreBD) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_ADMIN_USER, DB_ADMIN_PASS);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + nombreBD);
        }
    }

    private void crearUsuarioDB(String usuario, String password, String nombreBD) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_ADMIN_USER, DB_ADMIN_PASS);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE USER IF NOT EXISTS '" + usuario + "'@'%' IDENTIFIED BY '" + password + "'");
            stmt.executeUpdate("GRANT ALL PRIVILEGES ON " + nombreBD + ".* TO '" + usuario + "'@'%'");
        }
    }

    private void ejecutarScriptSQL(String nombreBD) throws Exception {
        // Aquí iría la lógica para leer y ejecutar un archivo SQL, como modelo.sql
        // Por ahora, solo simula la ejecución:
        System.out.println("Ejecutando script SQL en base de datos: " + nombreBD);
    }
}
