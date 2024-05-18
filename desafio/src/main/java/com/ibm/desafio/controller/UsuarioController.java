package com.ibm.desafio.controller;

import com.ibm.desafio.entity.DTO.RegisterDTO;
import com.ibm.desafio.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private AuthenticationService iAuthenticationService;
    @Operation(summary = "Registra um usuário", description = "Este endpoint é responsavel por cadastrar um usuário.")
    @PostMapping("/registro")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){

        return iAuthenticationService.register(data);
    }

    @Operation(summary = "Obter todos os usuários", description = "Este endpoint retorna todos os usuários cadastrados.")
    @GetMapping("/find")
    public ResponseEntity getAllUser(){

        return iAuthenticationService.getAllUser();
    }

    @Operation(summary = "Busca usuário por login", description = "Este endpoint retorna apenas um usuário a partir do seu login cadastrado.")
    @GetMapping("/findByLogin/{login}")
    public ResponseEntity findByLogin(@PathVariable @Valid String login){

        return iAuthenticationService.findByLogin(login);
    }

    @Operation(summary = "Exclui usuário por login", description = "Este endpoint é responsavel pela deleção de usuário cadastrado por login.")
    @PostMapping("/delete/{login}")
    public ResponseEntity deleteUser(@PathVariable @Valid String login){

        return iAuthenticationService.deleteUser(login);
    }

}
