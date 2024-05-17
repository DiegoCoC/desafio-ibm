package com.ibm.desafio.repository;

import com.ibm.desafio.entity.HistoricoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoTransacaoRepository extends JpaRepository<HistoricoTransacao, String> {

    HistoricoTransacao findByNumeroConta(String conta);
}
