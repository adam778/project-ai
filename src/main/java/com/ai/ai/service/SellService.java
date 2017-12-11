package com.ai.ai.service;

import com.ai.ai.dto.SellDto;

import java.util.List;

public interface SellService {

    List<SellDto> findAll();

    SellDto findOne(Long sellId);

    void deleteAll();

    void deleteOne(Long sellId);

    SellDto save(SellDto sellDto);

    SellDto insert(SellDto sellDto);

}
