package com.ibm.desafio.service.imp;

import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.GerarConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GerarContaImp implements GerarConta {

    @Autowired
    ContaRepository contaRepository;
    private final Random random = new Random();

    public String gerarNumeroConta() {
        String numeroConta;
        do {
            int primeiraParte = random.nextInt(9000) + 1000; // Gera um número entre 1000 e 9999
            int segundaParte = random.nextInt(90) + 10; // Gera um número entre 10 e 99
            numeroConta = String.format("%04d-%02d", primeiraParte, segundaParte);
        } while (contaRepository.existsByNumeroConta(numeroConta));
        return numeroConta;
    }
}
