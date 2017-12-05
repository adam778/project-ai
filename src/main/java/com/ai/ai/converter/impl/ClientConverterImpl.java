package com.ai.ai.converter.impl;

import com.ai.ai.converter.ClientConverter;
import com.ai.ai.database.Client;
import com.ai.ai.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientConverterImpl implements ClientConverter {

    @Override
    public Client convertToEntity(ClientDto dto) {
        return Client.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .companyName(dto.getCompanyName())
                .adress(dto.getAdress())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .build();
    }

    @Override
    public ClientDto convertToDto(Client entity) {
        return ClientDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .companyName(entity.getCompanyName())
                .adress(entity.getAdress())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .build();
    }
}
