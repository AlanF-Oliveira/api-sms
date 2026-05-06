package com.alan.api_sms.controller;

import com.alan.api_sms.dto.SmsRequestDTO;
import com.alan.api_sms.dto.SmsResponseDTO;
import com.alan.api_sms.dto.SmsUpdateDTO;
import com.alan.api_sms.enums.SmsStatus;
import com.alan.api_sms.service.SmsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sms")
@Tag(name = "Sms", description = "Gerenciamento de sms")
public class SmsController {
    private final SmsService service;

    @PostMapping
    @Operation(summary = "Cadastra um novo sms")
    @ApiResponse(responseCode = "201", description = "Sms criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Falha na criação")
    public ResponseEntity<SmsResponseDTO> cadastraSms(@RequestBody @Valid SmsRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastarSms(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza sms por id")
    @ApiResponse(responseCode = "200", description = "Sms atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Sms não encontrado")
    public ResponseEntity<SmsResponseDTO> atualizarStatusPorId(@PathVariable Long id, @RequestBody @Valid SmsUpdateDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarStatusPorId(id, dto));
    }

    @GetMapping("/relatorio")
    @Operation(summary = "Lista todos os sms por categoria")
    @ApiResponse(responseCode = "200", description = "Lista encontrada com sucesso")
    public ResponseEntity <List<SmsResponseDTO>> relatorioSms(@RequestParam SmsStatus status){
        return ResponseEntity.status(HttpStatus.OK).body(service.relatorioDeSmsEnviado(status));
    }

}
