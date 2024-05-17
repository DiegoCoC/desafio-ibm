package com.ibm.desafio.service;

import com.ibm.desafio.entity.Cliente;
import org.springframework.http.ResponseEntity;

public interface CriarConta {
    ResponseEntity criarConta(Cliente cliente);
}
