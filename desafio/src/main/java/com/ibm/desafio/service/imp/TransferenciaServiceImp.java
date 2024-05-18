package com.ibm.desafio.service.imp;

import com.ibm.desafio.service.DepositoService;
import com.ibm.desafio.service.SaqueService;
import com.ibm.desafio.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaServiceImp implements TransferenciaService {

    @Autowired
    SaqueService saqueService;
    @Autowired
    DepositoService depositoService;


    public ResponseEntity transferencia(String numeroContaSaque,String numeroContaDeposito, Double valor, String tipoTransacao){

        saqueService.saque(numeroContaSaque, valor, tipoTransacao);

        depositoService.deposito(numeroContaDeposito, valor, tipoTransacao);

        return ResponseEntity.ok(tipoTransacao + " realizada com sucesso!");
    }

}
