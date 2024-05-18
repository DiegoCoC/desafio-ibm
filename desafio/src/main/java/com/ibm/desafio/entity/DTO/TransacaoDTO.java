package com.ibm.desafio.entity.DTO;

import jakarta.validation.constraints.NotBlank;

public class TransacaoDTO {

    private String numeroConta;
    private Double valor;
    private String tipoTransacao;

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
