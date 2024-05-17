package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Conta;
import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaServiceImp implements TransferenciaService {

    @Autowired
    ContaRepository contaRepository;
    public ResponseEntity transferencia(String numeroContaSaque,String numeroContaRecebe, Double valor){
        if(valor <= 0){
            return ResponseEntity.badRequest().build();
        }
        Conta contaSaque = contaRepository.findByNumeroConta(numeroContaSaque);
        Conta contaRecebe = contaRepository.findByNumeroConta(numeroContaRecebe);
        if(contaSaque != null || contaRecebe != null){
            if(contaSaque.getSaldo() < valor){
                return ResponseEntity.notFound().build();
            }
            Double contaSaqueSaldo = contaSaque.getSaldo() - valor;
            contaSaque.setSaldo(contaSaqueSaldo);
            contaRepository.save(contaSaque);

            Double contaRecebeSaldo = contaRecebe.getSaldo() + valor;
            contaRecebe.setSaldo(contaRecebeSaldo);
            contaRepository.save(contaRecebe);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.notFound().build();
    }

}
