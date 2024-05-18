package com.ibm.desafio.repository;

import com.ibm.desafio.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {

    UserDetails findByLogin(String login);
}
