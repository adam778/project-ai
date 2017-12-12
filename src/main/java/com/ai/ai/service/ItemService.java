package com.ai.ai.service;

import com.ai.ai.dto.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> findAll();

    ItemDto findOne(Long itemId);

    void deleteAll();

    void deleteOne(Long itemId);

    ItemDto update(long itemId, ItemDto newItem);

    ItemDto insert(ItemDto itemDto);
}
