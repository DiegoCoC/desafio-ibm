package com.ibm.desafio.entity;

import com.ibm.desafio.entity.enums.TipoConta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conta")
@Entity()
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "conta")
    private String conta;
    @Column(name = "numeroConta")
    private String numeroConta;

}
