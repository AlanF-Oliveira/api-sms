package com.alan.api_sms.controller;

import com.alan.api_sms.dto.SmsRequestDTO;
import com.alan.api_sms.dto.SmsResponseDTO;
import com.alan.api_sms.dto.SmsUpdateDTO;
import com.alan.api_sms.enums.SmsStatus;
import com.alan.api_sms.service.SmsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sms")
public class SmsController {
    private final SmsService service;

    @PostMapping
    public ResponseEntity<SmsResponseDTO> cadastraSms(@RequestBody @Valid SmsRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastarSms(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SmsResponseDTO> atualizarStatusPorId(@PathVariable Long id, @RequestBody @Valid SmsUpdateDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarStatusPorId(id, dto));
    }

    @GetMapping("/relatorio")
    public ResponseEntity <List<SmsResponseDTO>> relatorioSms(@RequestParam SmsStatus status){
        return ResponseEntity.status(HttpStatus.OK).body(service.relatorioDeSmsEnviado(status));
    }

}
