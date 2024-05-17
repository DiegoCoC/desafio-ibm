package com.ibm.desafio.repository;

import com.ibm.desafio.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface ContaRepository extends JpaRepository<Conta, String> {

    public Conta findByNumeroConta(String numeroConta);
}
