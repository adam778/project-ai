package com.ai.ai.service.impl;

import com.ai.ai.converter.SellConventer;
import com.ai.ai.database.Sell;
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

    @Override
    public SellDto findOne(Long sellId) {
        return sellConventer.convertToDto(sellRepository.findOne(sellId));
    }

    @Override
    public void deleteAll() {
        sellRepository.deleteAll();
    }

    @Override
    public void deleteOne(Long sellId) {
        sellRepository.delete(sellId);
    }

    @Override
    public SellDto update(long sellId, SellDto sellDto) {
        SellDto currentSell = sellConventer.convertToDto(sellRepository.findOne(sellId));
        currentSell.setAmount(sellDto.getAmount());
        currentSell.setCustomerId(sellDto.getCustomerId());
        currentSell.setItemId(sellDto.getItemId());
        currentSell.setSellDate(sellDto.getSellDate());

        sellRepository.save(sellConventer.convertToEntity(currentSell));
        return currentSell;
    }

    @Override
    public SellDto insert(SellDto sellDto) {
        Sell newSell = sellRepository.save(sellConventer.convertToEntity(sellDto));
        return sellConventer.convertToDto(newSell);

    }



}
