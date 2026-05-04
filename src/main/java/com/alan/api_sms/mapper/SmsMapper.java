package com.alan.api_sms.mapper;

import com.alan.api_sms.dto.SmsRequestDTO;
import com.alan.api_sms.dto.SmsResponseDTO;
import com.alan.api_sms.entity.SmsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SmsMapper {
    SmsEntity paraEntity(SmsRequestDTO dto);
    SmsResponseDTO paraDTO(SmsEntity entity);

}
