package com.ai.ai.converter.impl;

import com.ai.ai.converter.SellConventer;
import com.ai.ai.database.Sell;
import com.ai.ai.dto.SellDto;
import org.springframework.stereotype.Component;

@Component
public class SellConventerImpl implements SellConventer {

    @Override
    public Sell convertToEntity(SellDto dto) {
        return Sell.builder()
                .id(dto.getId())
                .amount(dto.getAmount())
                .customerId(dto.getCustomerId())
                .itemId(dto.getItemId())
                .sellDate(dto.getSellDate())
                .build();
    }

    @Override
    public SellDto convertToDto(Sell entity) {
        return SellDto.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .customerId(entity.getCustomerId())
                .sellDate(entity.getSellDate())
                .itemId(entity.getItemId())
                .build();
    }
}
