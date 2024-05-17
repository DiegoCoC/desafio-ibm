package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.HistoricoTransacao;
import com.ibm.desafio.repository.HistoricoTransacaoRepository;
import com.ibm.desafio.service.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExtratoServiceImp implements ExtratoService {

    @Autowired
    HistoricoTransacaoRepository historicoTransacaoRepository;
    public ResponseEntity extrato(String conta){

        HistoricoTransacao historico = historicoTransacaoRepository.findByNumeroConta(conta);

        return ResponseEntity.ok(historico);
    }
}
