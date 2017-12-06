package com.ai.ai.service;

import com.ai.ai.dto.ClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> findAll();

    ClientDto findOne(Long clientId);

    void deleteAll();

    void deleteOne(Long clientId);

    void save(ClientDto clientDto);

    void insert(ClientDto clientDto);





}
