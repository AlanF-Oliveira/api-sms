package com.alan.api_sms.dto;

import com.alan.api_sms.enums.SmsStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsUpdateDTO {
    @NotNull
    private SmsStatus status;
}
