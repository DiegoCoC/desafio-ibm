package com.ibm.desafio.entity.enums;

public enum TipoConta {
    Corrente("corrente"),
    Poupanca("poupanca");

    private String role;

    TipoConta(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
