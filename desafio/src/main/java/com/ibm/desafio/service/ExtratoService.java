package com.ibm.desafio.service;

import com.ibm.desafio.entity.Cliente;
import com.ibm.desafio.entity.DTO.ExtratoRequestDTO;
import org.springframework.http.ResponseEntity;

public interface ExtratoService {

    ResponseEntity buscarExtrato(ExtratoRequestDTO numeroConta);

    void gerarExtrato(Cliente cliente, String transacao, Double valor);
}
