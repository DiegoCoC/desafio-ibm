package com.ibm.desafio.controller;

import com.ibm.desafio.entity.DTO.TransacaoDTO;
import com.ibm.desafio.entity.DTO.TransferenciaDTO;
import com.ibm.desafio.service.DepositoService;
import com.ibm.desafio.service.SaqueService;
import com.ibm.desafio.service.TransferenciaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacoesBancariasController {

    @Autowired
    DepositoService iDepositoService;
    @Autowired
    SaqueService iSaqueService;
    @Autowired
    TransferenciaService iTransferenciaService;

    @Operation(summary = "Depósito bancário", description = "Este end-point é responsavel por realizar o depósito bancário")
    @PostMapping("/deposito")
    public ResponseEntity depositoCliente(@RequestBody @Validated TransacaoDTO dto) {

        return iDepositoService.deposito(dto.getNumeroConta(), dto.getValor());
    }

    @Operation(summary = "Saque bancário", description = "Este end-point é responsavel por realizar o saque bancário")
    @PostMapping("/saque")
    public ResponseEntity saqueCliente(@RequestBody @Validated TransacaoDTO dto) {

        return iSaqueService.saque(dto.getNumeroConta(), dto.getValor());
    }

    @Operation(summary = "Trânsferencia bancário", description = "Este end-point é responsavel por realizar a trânsferencia bancária entre contas")
    @PostMapping("/transferencia")
    public ResponseEntity transferenciaCliente(@RequestBody @Validated TransferenciaDTO dto) {

        return iTransferenciaService.transferencia(dto.getNumeroContaSaque(), dto.getNumeroContaRecebe(), dto.getValor());
    }

    @Operation(summary = "Trânsferencia bancário", description = "Este end-point é responsavel por realizar a trânsferencia bancária entre contas")
    @PostMapping("/extrato")
    public ResponseEntity extrato(@RequestBody @Validated String conta) {

        return null;
    }


}
