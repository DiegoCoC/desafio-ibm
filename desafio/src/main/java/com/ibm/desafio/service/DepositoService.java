package com.ibm.desafio.service;

import org.springframework.http.ResponseEntity;

public interface DepositoService {

    ResponseEntity deposito(String numeroConta, Double valor);

}
