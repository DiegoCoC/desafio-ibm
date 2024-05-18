package com.ibm.desafio.service;

import com.ibm.desafio.entity.Usuario;

import java.time.Instant;

public interface TokenService {

    String generateToken(Usuario user);
    String validateToken(String token);
    Instant genExpirationDate();

}
