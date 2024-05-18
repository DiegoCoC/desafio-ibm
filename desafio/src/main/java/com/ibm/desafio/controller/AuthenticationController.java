package com.ibm.desafio.controller;

import com.ibm.desafio.entity.DTO.AuthenticationDTO;
import com.ibm.desafio.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Operation(summary = "Faz autenticação de usuário", description = "Este endpoint faz a autenticação de usuário e retorna um token para poder ter acesso aos demais endpoints.")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){

        return authenticationService.login(data);
    }
}
