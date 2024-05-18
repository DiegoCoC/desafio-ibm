package com.ibm.desafio.service.imp;


import com.ibm.desafio.entity.DTO.AuthenticationDTO;
import com.ibm.desafio.entity.DTO.LoginResponseDTO;
import com.ibm.desafio.entity.DTO.RegisterDTO;
import com.ibm.desafio.entity.Usuario;
import com.ibm.desafio.entity.enums.UserRole;
import com.ibm.desafio.repository.UserRepository;
import com.ibm.desafio.service.AuthenticationService;
import com.ibm.desafio.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    TokenService tokenService;

    @Override
    public ResponseEntity register(RegisterDTO data) {
        if (userRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario newUser = new Usuario(data.login(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity login(AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());

        //var auth = this.authenticationManager.authenticate(usernamePassword);

        Usuario usuario = new Usuario(data.login(), data.password(), UserRole.ADMIN);

        var token = tokenService.generateToken((Usuario) usuario);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Override
    public ResponseEntity getAllUser() {
        List<Usuario> allUser =  this.userRepository.findAll();
        return ResponseEntity.ok(allUser);
    }

    @Override
    public ResponseEntity deleteUser(String login) {
        Usuario user = (Usuario) this.userRepository.findByLogin(login);
        if(user == null){
            return ResponseEntity.badRequest().build();
        }
        this.userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity findByLogin(String login) {
        Usuario user = (Usuario) this.userRepository.findByLogin(login);

        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}
