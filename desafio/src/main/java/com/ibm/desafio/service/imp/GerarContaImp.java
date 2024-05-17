package com.ibm.desafio.service.imp;

import com.ibm.desafio.service.GerarConta;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GerarContaImp implements GerarConta {

    public String gerarNumeroConta(){
        Random random = new Random();
        int primeiraParte = random.nextInt(9000) + 1000;
        int segundaParte = random.nextInt(90) + 10;
        return String.format("%04d-%02d", primeiraParte, segundaParte);
    }
}
