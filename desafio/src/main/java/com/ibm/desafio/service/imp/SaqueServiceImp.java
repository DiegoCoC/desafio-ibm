package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Conta;
import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.SaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaqueServiceImp implements SaqueService {

    @Autowired
    ContaRepository contaRepository;

    public ResponseEntity saque(String numeroConta, Double valor){
        if(valor <= 0){
            return ResponseEntity.badRequest().build();
        }
        Conta conta = contaRepository.findByNumeroConta(numeroConta);
        if(conta != null){
            if(conta.getSaldo() < valor){
                return ResponseEntity.notFound().build();
            }
            Double saldo = conta.getSaldo() - valor;
            conta.setSaldo(saldo);
            contaRepository.save(conta);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }
}
