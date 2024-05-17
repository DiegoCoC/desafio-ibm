package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Conta;
import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.ExtratoService;
import com.ibm.desafio.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaServiceImp implements TransferenciaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    ExtratoService extratoService;

    public ResponseEntity transferencia(String numeroContaSaque,String numeroContaRecebe, Double valor){
        if(valor <= 0){
            return ResponseEntity.badRequest().body("O valor informado não pode ser 0 ou negativo.");
        }
        Conta contaSaque = contaRepository.findByNumeroConta(numeroContaSaque);
        Conta contaRecebe = contaRepository.findByNumeroConta(numeroContaRecebe);
        if(contaSaque != null || contaRecebe != null){
            if(contaSaque.getSaldo() < valor){
                return ResponseEntity.badRequest().body("Saldo insuficiente para realizar a transferência.");
            }
            Double contaSaqueSaldo = contaSaque.getSaldo() - valor;
            contaSaque.setSaldo(contaSaqueSaldo);
            contaRepository.save(contaSaque);

            Double contaRecebeSaldo = contaRecebe.getSaldo() + valor;
            contaRecebe.setSaldo(contaRecebeSaldo);
            contaRepository.save(contaRecebe);
            return ResponseEntity.ok("Transferência concluída com sucesso para " + contaRecebe.getNumeroConta());
        }
        return ResponseEntity.badRequest().body("Conta não encontrada.");
    }

}
