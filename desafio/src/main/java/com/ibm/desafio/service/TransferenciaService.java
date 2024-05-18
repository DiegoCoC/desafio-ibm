package com.ibm.desafio.service;

import org.springframework.http.ResponseEntity;

public interface TransferenciaService {

    ResponseEntity transferencia(String numeroContaSaque, String numeroContaDeposito, Double valor, String tipoTransacao);
}
