package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Cliente;
import com.ibm.desafio.entity.Conta;
import com.ibm.desafio.repository.ClienteRepository;
import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.ExtratoService;
import com.ibm.desafio.service.SaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SaqueServiceImp implements SaqueService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ExtratoService extratoService;

    public ResponseEntity saque(String numeroContaSaque, Double valor, String tipoTransacao){
        if(valor <= 0){
            return ResponseEntity.badRequest().body("O valor informado não pode ser 0 ou negativo.");
        }
        Cliente conta = clienteRepository.findByNumeroContaCliente(numeroContaSaque);
        if(conta != null){
            if(conta.getNumero().getSaldo() < valor){
                return ResponseEntity.badRequest().body("Saldo insuficiente para realizar o saque.");
            }
            Double saldo = conta.getNumero().getSaldo() - valor;
            conta.getNumero().setSaldo(saldo);
            contaRepository.save(conta.getNumero());
            extratoService.gerarExtrato(conta, tipoTransacao, valor);
            return ResponseEntity.ok(tipoTransacao + " realizado com sucesso!");
        }
        return ResponseEntity.badRequest().body("Conta não encontrada.");
    }
}
