package com.ai.ai.service.impl;

import com.ai.ai.converter.ItemConventer;
import com.ai.ai.database.ItemRepository;
import com.ai.ai.dto.ItemDto;
import com.ai.ai.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private ItemConventer itemConventer;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemConventer itemConventer) {
        this.itemRepository = itemRepository;
        this.itemConventer = itemConventer;
    }


    @Override
    public List<ItemDto> findAll() {
        return this.itemRepository.findAll().stream()
                .map(item -> itemConventer.convertToDto(item))
                .collect(Collectors.toList());

    }
}
