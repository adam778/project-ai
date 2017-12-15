package com.ai.ai.controller;


import com.ai.ai.dto.SellDto;
import com.ai.ai.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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


    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public void uploadAndParseFile(@RequestParam("file") MultipartFile uploadedFile) {
        sellService.importCsv(uploadedFile);
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource export() throws IOException {
        return new FileSystemResource(sellService.exportCsv());
    }

    @RequestMapping(value = "/chartData", method = RequestMethod.GET)
    @ResponseBody
    public Map<Long, Integer> getDataForChart() throws IOException {
        return sellService.getDataForChart();
    }


}
