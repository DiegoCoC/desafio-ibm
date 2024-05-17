package com.ibm.desafio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Conta getNumero() {
        return numero;
    }

    public void setNumero(Conta numero) {
        this.numero = numero;
    }
}
