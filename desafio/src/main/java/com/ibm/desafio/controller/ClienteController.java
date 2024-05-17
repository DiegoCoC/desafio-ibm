package com.ibm.desafio.controller;

import com.ibm.desafio.entity.Cliente;
import com.ibm.desafio.repository.ClienteRepository;
import com.ibm.desafio.service.CriarConta;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    CriarConta criarConta;

    @Operation(summary = "Cadastro de cliente", description = "Este end-point é responsavel por cadastrar clientes")
    @PostMapping("/")
    public ResponseEntity registroCliente(@RequestBody @Validated Cliente cliente){

        return criarConta.criarConta(cliente);
    }
}
