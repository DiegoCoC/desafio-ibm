package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Conta;
import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.DepositoService;
import com.ibm.desafio.service.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepositoServiceImp implements DepositoService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    ExtratoService extratoService;

    public ResponseEntity deposito(String numeroConta, Double valor){
        if(valor <= 0){
            return ResponseEntity.badRequest().body("O valor informado não pode ser 0 ou negativo.");
        }
        Conta conta = contaRepository.findByNumeroConta(numeroConta);
        if(conta != null){
            Double saldo = conta.getSaldo() + valor;
            conta.setSaldo(saldo);
            contaRepository.save(conta);
            return ResponseEntity.ok("Depósito de R$:"+valor+" realizado com sucesso!");
        }
        return ResponseEntity.badRequest().body("Conta não encontrada.");
    }

}
