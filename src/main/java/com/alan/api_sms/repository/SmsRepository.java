package com.alan.api_sms.repository;

import com.alan.api_sms.entity.SmsEntity;
import com.alan.api_sms.enums.SmsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SmsRepository extends JpaRepository<SmsEntity, Long> {
    List<SmsEntity> findByStatusAndSentAtAfter(SmsStatus status, LocalDateTime time);

}
