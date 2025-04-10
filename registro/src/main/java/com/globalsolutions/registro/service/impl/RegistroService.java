package com.globalsolutions.registro.service.impl;

import com.globalsolutions.registro.model.RegistroClienteRequest;

public interface RegistroService {
    void procesarRegistro(RegistroClienteRequest request) throws Exception;
}
