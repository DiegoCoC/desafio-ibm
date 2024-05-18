package com.ibm.desafio.service;

import com.ibm.desafio.entity.DTO.AuthenticationDTO;
import com.ibm.desafio.entity.DTO.RegisterDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity register(RegisterDTO data);
    ResponseEntity login(AuthenticationDTO data);
    ResponseEntity getAllUser();
    ResponseEntity deleteUser(String login);
    ResponseEntity findByLogin(String login);

}
