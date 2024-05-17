package com.ibm.desafio.entity;

import jakarta.persistence.*;

@Table(name = "cliente")
@Entity(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "email")
    private String email;
    @Column(name = "numero")
    private Conta numero;
}
