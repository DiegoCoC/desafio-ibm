package com.ibm.desafio.repository;

import com.ibm.desafio.entity.HistoricoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoTransacaoRepository extends JpaRepository<HistoricoTransacao, String> {

    List<HistoricoTransacao> findAllByNumeroConta(String numeroConta);
}
