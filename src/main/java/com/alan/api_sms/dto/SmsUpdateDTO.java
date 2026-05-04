package com.alan.api_sms.dto;

import com.alan.api_sms.enums.SmsStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsUpdateDTO {
    private SmsStatus status;
}
