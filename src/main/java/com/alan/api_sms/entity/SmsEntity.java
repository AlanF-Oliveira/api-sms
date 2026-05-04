package com.alan.api_sms.entity;

import com.alan.api_sms.enums.SmsStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private SmsStatus status;
    private LocalDateTime sentAt;
}
