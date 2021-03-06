package com.ai.ai.service.impl;

import com.ai.ai.converter.SellConventer;
import com.ai.ai.database.Sell;
import com.ai.ai.database.SellRepository;
import com.ai.ai.dto.SellDto;
import com.ai.ai.service.SellService;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Override
    public void importCsv(MultipartFile uploadedFile) {
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(uploadedFile.getInputStream()), ';');
            List<String[]> allDataInFile = csvReader.readAll();
            List<String[]> data = allDataInFile.subList(0, allDataInFile.size());
            for (String[] line : data) {
                sellRepository.save(buildSellObjectFromStringArray(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Sell buildSellObjectFromStringArray(String[] line) {
        Sell sell = new Sell();
        sell.setCustomerId(Long.valueOf(line[0]));
        sell.setItemId(Long.valueOf(line[1]));
        sell.setSellDate(line[2]);
        sell.setAmount(Integer.valueOf(line[3]));
        return sell;
    }


    @Override
    public File exportCsv() throws IOException {
        File export = File.createTempFile("export", ".csv");
        CSVWriter csvWriter = new CSVWriter(new FileWriter(export), ';', '\n');

        csvWriter.writeAll(sellRepository.findAll().stream().map(sell -> {
                    return new String[]{sell.getCustomerId().toString(),
                            sell.getItemId().toString(),
                            sell.getSellDate(),
                            sell.getAmount() + ""};})
        .collect(Collectors.toList()));
        csvWriter.close();

        return export;
    }

    @Override
    public Map<Long, Integer> getDataForChart() {
         return sellRepository.findAll().stream()
                .collect(Collectors.groupingBy(Sell::getCustomerId, Collectors.summingInt(Sell::getAmount)));
    }
}
