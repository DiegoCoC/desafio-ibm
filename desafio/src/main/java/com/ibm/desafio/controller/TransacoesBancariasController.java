package com.ibm.desafio.controller;

import com.ibm.desafio.entity.DTO.ExtratoRequestDTO;
import com.ibm.desafio.entity.DTO.TransacaoDTO;
import com.ibm.desafio.entity.DTO.TransferenciaDTO;
import com.ibm.desafio.service.DepositoService;
import com.ibm.desafio.service.ExtratoService;
import com.ibm.desafio.service.SaqueService;
import com.ibm.desafio.service.TransferenciaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacoesBancariasController {

    @Autowired
    DepositoService depositoService;
    @Autowired
    SaqueService saqueService;
    @Autowired
    TransferenciaService transferenciaService;
    @Autowired
    ExtratoService extratoService;

    @Operation(summary = "Depósito bancário", description = "Este end-point é responsavel por realizar o depósito bancário")
    @PostMapping("/deposito")
    public ResponseEntity depositoCliente(@RequestBody @Validated TransacaoDTO dto) {

        return depositoService.deposito(dto.getNumeroConta(), dto.getValor(), dto.getTipoTransacao());
    }

    @Operation(summary = "Saque bancário", description = "Este end-point é responsavel por realizar o saque bancário")
    @PostMapping("/saque")
    public ResponseEntity saqueCliente(@RequestBody @Validated TransacaoDTO dto) {

        return saqueService.saque(dto.getNumeroConta(), dto.getValor(), dto.getTipoTransacao());
    }

    @Operation(summary = "Trânsferencia bancário", description = "Este end-point é responsavel por realizar a trânsferencia bancária entre contas")
    @PostMapping("/transferencia")
    public ResponseEntity transferenciaCliente(@RequestBody @Validated TransferenciaDTO dto) {

        return transferenciaService.transferencia(dto.getNumeroContaSaque(), dto.getNumeroContaRecebe(), dto.getValor(), dto.getTipoTransacao());
    }

    @Operation(summary = "Extrato bancário", description = "Este end-point é responsavel por realizar o Extrato bancária")
    @PostMapping("/extrato")
    public ResponseEntity extrato(@RequestBody @Validated ExtratoRequestDTO numeroConta) {

        return  extratoService.buscarExtrato(numeroConta);
    }


}
