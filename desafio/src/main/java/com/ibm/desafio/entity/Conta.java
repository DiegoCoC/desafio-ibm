package com.ibm.desafio.entity;

import com.ibm.desafio.entity.enums.TipoConta;
import jakarta.persistence.*;

@Table(name = "conta")
@Entity(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    private TipoConta conta;
    @Column(name = "numeroConta")
    private String numeroConta;

}
