package com.alan.api_sms.dto;

import com.alan.api_sms.enums.SmsStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsResponseDTO {
    private Long id;
    private String phoneNumber;
    private SmsStatus status;
    private LocalDateTime sentAt;

}
