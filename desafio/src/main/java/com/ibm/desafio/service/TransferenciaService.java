package com.ibm.desafio.service;

import org.springframework.http.ResponseEntity;

public interface TransferenciaService {

    ResponseEntity transferencia(String numeroContaSaque, String numeroContaRecebe, Double valor);
}
