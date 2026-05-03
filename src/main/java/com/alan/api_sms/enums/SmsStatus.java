package com.alan.api_sms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SmsStatus {
    ENVIADO("Enviado"),
    RECEBIDO("Recebido"),
    ERRO_DE_ENVIO("Erro de envio");
    private final String enumStatus;
}
