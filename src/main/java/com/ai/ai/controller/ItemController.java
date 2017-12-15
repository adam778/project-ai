package com.ai.ai.controller;


import com.ai.ai.dto.ItemDto;
import com.ai.ai.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<ItemDto> getAll() {
        return itemService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ItemDto getOne(@PathVariable(name = "id") Long itemId) {
        return itemService.findOne(itemId);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    void deleteAll() {
        itemService.deleteAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteOne(@PathVariable(name = "id") Long itemId) {
        itemService.deleteOne(itemId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ItemDto updateOne(@PathVariable(value = "id") Long itemId, @RequestBody ItemDto item) {
        return itemService.update(itemId, item);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ItemDto insertOne(@RequestBody ItemDto itemDto) {
        return itemService.insert(itemDto);
    }
}
