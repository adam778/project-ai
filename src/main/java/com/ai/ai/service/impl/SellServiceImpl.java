package com.ai.ai.service.impl;

import com.ai.ai.converter.SellConventer;
import com.ai.ai.database.SellRepository;
import com.ai.ai.dto.SellDto;
import com.ai.ai.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellServiceImpl implements SellService {

    private SellRepository sellRepository;
    private SellConventer sellConventer;

    @Autowired
    public SellServiceImpl(SellRepository sellRepository, SellConventer sellConventer) {
        this.sellRepository = sellRepository;
        this.sellConventer = sellConventer;
    }

    @Override
    public List<SellDto> findAll() {
        return sellRepository.findAll().stream()
                .map(sell -> sellConventer.convertToDto(sell))
                .collect(Collectors.toList());
    }
}
