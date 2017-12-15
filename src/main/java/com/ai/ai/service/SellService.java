package com.ai.ai.service;

import com.ai.ai.dto.SellDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SellService {

    List<SellDto> findAll();

    SellDto findOne(Long sellId);

    void deleteAll();

    void deleteOne(Long sellId);

    SellDto update(long sellId, SellDto sellDto);

    SellDto insert(SellDto sellDto);

    void importCsv(MultipartFile uploadedFile);

    File exportCsv() throws IOException;

    Map<Long, Integer> getDataForChart();

}
