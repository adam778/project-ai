package com.ai.ai.service.impl;

import com.ai.ai.converter.SellConventer;
import com.ai.ai.database.Sell;
import com.ai.ai.database.SellRepository;
import com.ai.ai.dto.SellDto;
import com.ai.ai.service.SellService;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Date;
import java.util.List;
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
    public SellDto save(SellDto sellDto) {
        sellRepository.save(sellConventer.convertToEntity(sellDto));
        return sellDto;
    }

    @Override
    public SellDto insert(SellDto sellDto) {
        Sell newSell = sellRepository.save(sellConventer.convertToEntity(sellDto));
        return sellConventer.convertToDto(newSell);

    }

    @Override
    public void uploadAndParseFile(MultipartFile uploadedFile) {
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(uploadedFile.getInputStream()), ';');
            List<String[]> allDataInFile = csvReader.readAll();
            List<String[]> data = allDataInFile.subList(0, allDataInFile.size());
            for (String[] line : data){
                Sell sell = new Sell();
                sell.setCustomerId(Long.valueOf(line[0]));
                sell.setItemId(Long.valueOf(line[1]));
                sell.setSellDate(line[2]);
                sell.setAmount(Integer.valueOf(line[3]));
                sellRepository.save(sell);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
