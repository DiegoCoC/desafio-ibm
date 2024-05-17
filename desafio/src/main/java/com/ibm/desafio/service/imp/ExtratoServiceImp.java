package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Cliente;
import com.ibm.desafio.entity.HistoricoTransacao;
import com.ibm.desafio.repository.HistoricoTransacaoRepository;
import com.ibm.desafio.service.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExtratoServiceImp implements ExtratoService {

    @Autowired
    HistoricoTransacaoRepository historicoTransacaoRepository;
    public ResponseEntity buscarExtrato(String conta){

        HistoricoTransacao historico = historicoTransacaoRepository.findByNumeroConta(conta);

        return ResponseEntity.ok(historico);
    }


    public void gerarExtrato(Cliente cliente) {
        if (cliente == null || cliente.getNumero() == null) {
            throw new IllegalArgumentException("Cliente ou Conta não podem ser nulos");
        }

        HistoricoTransacao historico = new HistoricoTransacao();
        historico.setNome(cliente.getNome());
        historico.setTipoConta(cliente.getNumero().getTipoConta());
        historico.setNumeroConta(cliente.getNumero().getNumeroConta());
        historico.setSaldo(cliente.getNumero().getSaldo());
        historico.setData(LocalDateTime.now());

        historicoTransacaoRepository.save(historico);
    }
}
