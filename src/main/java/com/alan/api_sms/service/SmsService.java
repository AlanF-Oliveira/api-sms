package com.alan.api_sms.service;

import com.alan.api_sms.dto.SmsRequestDTO;
import com.alan.api_sms.dto.SmsResponseDTO;
import com.alan.api_sms.dto.SmsUpdateDTO;
import com.alan.api_sms.entity.SmsEntity;
import com.alan.api_sms.enums.SmsStatus;
import com.alan.api_sms.mapper.SmsMapper;
import com.alan.api_sms.repository.SmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final SmsRepository repository;
    private final SmsMapper mapper;
    public SmsResponseDTO cadastarSms(SmsRequestDTO dto){
        SmsEntity entity = mapper.paraEntity(dto);
        entity.setSentAt(LocalDateTime.now());
        entity.setStatus(SmsStatus.ENVIADO);
        SmsEntity entitySalva = repository.save(entity);
        return mapper.paraDTO(entitySalva);
    }
    private  SmsEntity buscarMensagemPorId(Long id){
        return  repository.findById(id).
                orElseThrow(() -> new RuntimeException("Mensagem não encontrada"));
    }

    public SmsResponseDTO atualizarStatus(Long id, SmsUpdateDTO dto){
        SmsEntity entity = buscarMensagemPorId(id);
        entity.setStatus(dto.getStatus());
        repository.save(entity);
        return mapper.paraDTO(entity);
    }

    public List<SmsResponseDTO> relatorioDeSmsEnviado(SmsStatus status){
        List<SmsEntity> entities = repository.findByStatusAndSentAtAfter(status,LocalDateTime.now().minusHours(24));
        return mapper.paraDTOList(entities);
    }
}
