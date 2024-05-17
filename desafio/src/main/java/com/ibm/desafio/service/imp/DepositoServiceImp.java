package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Conta;
import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepositoServiceImp implements DepositoService {

    @Autowired
    ContaRepository contaRepository;

    public ResponseEntity deposito(String numeroConta, Double valor){
        if(valor <= 0){
            return ResponseEntity.badRequest().build();
        }
        Conta conta = contaRepository.findByNumeroConta(numeroConta);
        if(conta != null){
            Double saldo = conta.getSaldo() + valor;
            conta.setSaldo(saldo);
            contaRepository.save(conta);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }

}
