package com.ibm.desafio.repository;

import com.ibm.desafio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("SELECT c FROM Cliente c WHERE c.numero.numeroConta = :numeroConta")
    Cliente findByNumeroContaCliente(@Param("numeroConta") String numeroConta);
}
