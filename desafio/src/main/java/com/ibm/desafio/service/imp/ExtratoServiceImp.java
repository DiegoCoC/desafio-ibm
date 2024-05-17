package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Cliente;
import com.ibm.desafio.entity.DTO.ExtratoRequestDTO;
import com.ibm.desafio.entity.DTO.HistoricoTransacaoDTO;
import com.ibm.desafio.entity.HistoricoTransacao;
import com.ibm.desafio.repository.HistoricoTransacaoRepository;
import com.ibm.desafio.service.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtratoServiceImp implements ExtratoService {

    @Autowired
    HistoricoTransacaoRepository historicoTransacaoRepository;
    public ResponseEntity buscarExtrato(ExtratoRequestDTO numeroConta){

        List<HistoricoTransacao> historico = historicoTransacaoRepository.findAllByNumeroConta(numeroConta.getConta());

        List<HistoricoTransacaoDTO> historicoDTOs = historico.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(historicoDTOs);
    }


    public void gerarExtrato(Cliente cliente, String transacao, Double valor) {
        if (cliente == null || cliente.getNumero() == null) {
            throw new IllegalArgumentException("Cliente ou Conta não podem ser nulos");
        }

        HistoricoTransacao historico = new HistoricoTransacao();
        historico.setNome(cliente.getNome());
        historico.setTipoConta(cliente.getNumero().getTipoConta());
        historico.setNumeroConta(cliente.getNumero().getNumeroConta());
        historico.setSaldo(cliente.getNumero().getSaldo());
        historico.setTransacao(transacao);
        historico.setValor(valor);
        historico.setData(LocalDateTime.now());

        historicoTransacaoRepository.save(historico);
    }


    private HistoricoTransacaoDTO toDTO(HistoricoTransacao historico) {
        HistoricoTransacaoDTO dto = new HistoricoTransacaoDTO();
        dto.setNome(historico.getNome());
        dto.setTipoConta(historico.getTipoConta());
        dto.setNumeroConta(historico.getNumeroConta());
        dto.setSaldo(historico.getSaldo());
        dto.setTransacao(historico.getTransacao());
        dto.setValor(historico.getValor());
        dto.setData(historico.getData());
        return dto;
    }
}
