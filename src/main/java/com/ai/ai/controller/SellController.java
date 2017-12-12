package com.ai.ai.controller;


import com.ai.ai.dto.SellDto;
import com.ai.ai.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sell")
public class SellController {

    private SellService sellService;

    @Autowired
    public SellController(SellService sellService) {
        this.sellService = sellService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<SellDto> getAll() {
        return sellService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    SellDto getOne(@PathVariable(name = "id") Long sellId) {
        return sellService.findOne(sellId);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    void deleteAll() {
        sellService.deleteAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteOne(@PathVariable(name = "id") Long sellId) {
        sellService.deleteOne(sellId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    SellDto updateOne(@PathVariable(value = "id") Long sellId, @RequestBody SellDto sell) {
        return sellService.update(sellId, sell);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    SellDto insertOne(@RequestBody SellDto sellDto) {
        return sellService.insert(sellDto);
    }


}
