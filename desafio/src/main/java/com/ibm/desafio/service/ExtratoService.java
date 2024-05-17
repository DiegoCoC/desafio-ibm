package com.ibm.desafio.service;

import com.ibm.desafio.entity.HistoricoTransacao;
import org.springframework.http.ResponseEntity;

public interface ExtratoService {

    ResponseEntity extrato(String conta);
}
