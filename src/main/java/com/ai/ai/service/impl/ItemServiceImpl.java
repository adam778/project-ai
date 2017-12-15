package com.ai.ai.service.impl;

import com.ai.ai.converter.ItemConventer;
import com.ai.ai.database.Item;
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

    @Override
    public ItemDto findOne(Long itemId) {
        return itemConventer.convertToDto(itemRepository.findOne(itemId));
    }

    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }

    @Override
    public void deleteOne(Long itemId) {
        itemRepository.delete(itemId);
    }

    @Override
    public ItemDto update(long itemId, ItemDto newItem) {
        ItemDto currentItem = itemConventer.convertToDto(itemRepository.findOne(itemId));
        currentItem.setName(newItem.getName());
        itemRepository.save(itemConventer.convertToEntity(currentItem));
        return currentItem;
    }

    @Override
    public ItemDto insert(ItemDto itemDto) {
        Item newSell = itemRepository.save(itemConventer.convertToEntity(itemDto));
        return itemConventer.convertToDto(newSell);

    }


}
