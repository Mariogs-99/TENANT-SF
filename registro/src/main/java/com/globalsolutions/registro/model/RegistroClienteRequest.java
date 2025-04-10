package com.globalsolutions.registro.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroClienteRequest {
    private String nombreEmpresa;
    private String nit;
    private String correoContacto;
    private String telefono;
}
