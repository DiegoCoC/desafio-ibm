package com.ibm.desafio.service;

import org.springframework.http.ResponseEntity;

public interface SaqueService {

    ResponseEntity saque(String numeroConta, Double valor);
}
