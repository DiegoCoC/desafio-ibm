package com.ibm.desafio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
@Entity()
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
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "conta_id")
    private Conta numero;
}
