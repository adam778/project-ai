package com.ai.ai.service.impl;

import com.ai.ai.converter.ClientConverter;
import com.ai.ai.database.ClientRepository;
import com.ai.ai.dto.ClientDto;
import com.ai.ai.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private ClientConverter clientConverter;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository,
                             ClientConverter clientConverter) {
        this.clientRepository = clientRepository;
        this.clientConverter = clientConverter;
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(client -> clientConverter.convertToDto(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findOne(Long clientId) {
        return clientConverter.convertToDto(clientRepository.findOne(clientId));
    }

    @Override
    public void deleteAll() {
        clientRepository.deleteAll();
    }

    @Override
    public void deleteOne(Long clientId) {
        clientRepository.delete(clientId);
    }

    @Override
    public void save(ClientDto clientDto) {
        clientRepository.save(clientConverter.convertToEntity(clientDto));
    }

    @Override
    public void insert(ClientDto clientDto) {
        clientRepository.save(clientConverter.convertToEntity(clientDto));
    }
}
