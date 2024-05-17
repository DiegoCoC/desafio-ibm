package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Conta;
import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.ExtratoService;
import com.ibm.desafio.service.SaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaqueServiceImp implements SaqueService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    ExtratoService extratoService;

    public ResponseEntity saque(String numeroConta, Double valor){
        if(valor <= 0){
            return ResponseEntity.badRequest().body("O valor informado não pode ser 0 ou negativo.");
        }
        Conta conta = contaRepository.findByNumeroConta(numeroConta);
        if(conta != null){
            if(conta.getSaldo() < valor){
                return ResponseEntity.badRequest().body("Saldo insuficiente para realizar o saque.");
            }
            Double saldo = conta.getSaldo() - valor;
            conta.setSaldo(saldo);
            contaRepository.save(conta);
            return ResponseEntity.ok("Saque de R$:"+valor+" realizado com sucesso!");
        }
        return ResponseEntity.badRequest().body("Conta não encontrada.");
    }
}
