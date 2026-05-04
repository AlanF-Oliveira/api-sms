package com.alan.api_sms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsRequestDTO {
    @NotBlank
    private String phoneNumber;
}
