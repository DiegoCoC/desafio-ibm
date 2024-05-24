package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Cliente;
import com.ibm.desafio.repository.ClienteRepository;
import com.ibm.desafio.service.CriarConta;
import com.ibm.desafio.service.GerarConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CriarContaImp implements CriarConta {

    @Autowired
    GerarConta gerarConta;
    @Autowired
    ClienteRepository clienteRepository;

    public ResponseEntity criarConta(Cliente cliente){

        cliente.getNumero().setNumeroConta(gerarConta.gerarNumeroConta());

        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
