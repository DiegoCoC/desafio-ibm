package com.ibm.desafio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historico")
@Entity()
public class HistoricoTransacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "tipoConta")
    private String tipoConta;
    @Column(name = "numeroConta")
    private String numeroConta;
    @Column(name = "saldo")
    private Double saldo;
    @Column(name = "transacao")
    private String transacao;
    @Column(name = "valor")
    private Double valor;
    @Column(name = "data")
    private LocalDateTime data;

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

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTransacao() {
        return transacao;
    }

    public void setTransacao(String transacao) {
        this.transacao = transacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
