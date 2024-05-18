package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Cliente;
import com.ibm.desafio.entity.Conta;
import com.ibm.desafio.repository.ClienteRepository;
import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.DepositoService;
import com.ibm.desafio.service.ExtratoService;
import com.ibm.desafio.service.SaqueService;
import com.ibm.desafio.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaServiceImp implements TransferenciaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ExtratoService extratoService;
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
