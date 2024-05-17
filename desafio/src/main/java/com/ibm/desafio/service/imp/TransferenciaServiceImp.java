package com.ibm.desafio.service.imp;

import com.ibm.desafio.entity.Cliente;
import com.ibm.desafio.entity.Conta;
import com.ibm.desafio.repository.ClienteRepository;
import com.ibm.desafio.repository.ContaRepository;
import com.ibm.desafio.service.ExtratoService;
import com.ibm.desafio.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaServiceImp implements TransferenciaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ExtratoService extratoService;

    public ResponseEntity transferencia(String numeroContaSaque,String numeroContaRecebe, Double valor){
        if(valor <= 0){
            return ResponseEntity.badRequest().body("O valor informado não pode ser 0 ou negativo.");
        }
        Cliente contaSaque = clienteRepository.findByNumeroContaCliente(numeroContaSaque);
        Cliente contaRecebe = clienteRepository.findByNumeroContaCliente(numeroContaRecebe);
        if(contaSaque != null || contaRecebe != null){
            if(contaSaque.getNumero().getSaldo() < valor){
                return ResponseEntity.badRequest().body("Saldo insuficiente para realizar a transferência.");
            }
            Double contaSaqueSaldo = contaSaque.getNumero().getSaldo() - valor;
            contaSaque.getNumero().setSaldo(contaSaqueSaldo);
            contaRepository.save(contaSaque.getNumero());

            Double contaRecebeSaldo = contaRecebe.getNumero().getSaldo() + valor;
            contaRecebe.getNumero().setSaldo(contaRecebeSaldo);
            contaRepository.save(contaSaque.getNumero());

            extratoService.gerarExtrato(contaSaque, "trânsferencia", valor);
            return ResponseEntity.ok("Transferência concluída com sucesso para " + contaRecebe.getNumero().getNumeroConta());
        }
        return ResponseEntity.badRequest().body("Conta não encontrada.");
    }

}
