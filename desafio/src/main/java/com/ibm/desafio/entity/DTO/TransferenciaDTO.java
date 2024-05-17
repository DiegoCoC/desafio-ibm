package com.ibm.desafio.entity.DTO;

public class TransferenciaDTO {

    private String numeroContaSaque;
    private String numeroContaRecebe;
    private Double valor;

    public String getNumeroContaSaque() {
        return numeroContaSaque;
    }

    public void setNumeroContaSaque(String numeroContaSaque) {
        this.numeroContaSaque = numeroContaSaque;
    }

    public String getNumeroContaRecebe() {
        return numeroContaRecebe;
    }

    public void setNumeroContaRecebe(String numeroContaRecebe) {
        this.numeroContaRecebe = numeroContaRecebe;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
