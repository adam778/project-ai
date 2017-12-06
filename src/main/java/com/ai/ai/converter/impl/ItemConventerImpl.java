package com.ai.ai.converter.impl;

import com.ai.ai.converter.ItemConventer;
import com.ai.ai.database.Item;
import com.ai.ai.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemConventerImpl implements ItemConventer {

    @Override
    public Item convertToEntity(ItemDto dto) {
        return Item.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public ItemDto convertToDto(Item entity) {
        return ItemDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
