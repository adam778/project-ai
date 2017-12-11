package com.ai.ai.service;

import com.ai.ai.dto.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> findAll();

    ItemDto findOne(Long itemId);

    void deleteAll();

    void deleteOne(Long itemId);

    ItemDto save(ItemDto itemDto);

    ItemDto insert(ItemDto itemDto);
}
