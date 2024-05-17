package com.ibm.desafio.service;

import com.ibm.desafio.entity.Cliente;
import com.ibm.desafio.entity.HistoricoTransacao;
import org.springframework.http.ResponseEntity;

public interface ExtratoService {

    ResponseEntity buscarExtrato(String conta);

    void gerarExtrato(Cliente cliente);
}
