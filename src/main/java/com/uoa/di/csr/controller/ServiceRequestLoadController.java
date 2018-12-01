package com.uoa.di.csr.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.uoa.di.csr.converter.ServiceRequestCsvToServiceRequest;
import com.uoa.di.csr.parser.model.ServiceRequestCsv;
import com.uoa.di.csr.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@RestController
public class ServiceRequestLoadController {

    private static final String SERVICE_REQUESTS_ABANDONED_VEHICLES = "311-service-requests-abandoned-vehicles";

    private static String CSV_FILE_EXTENSION = ".csv";

    private static Boolean RUNNING_ALREADY = Boolean.FALSE;

    @Value("${csr.csv.files.base.folder}")
    private String csvBaseFolder;


    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;


    @GetMapping("load-service-requests/{csvFileName}")
    public ResponseEntity loadServiceRequests(@PathVariable("csvFileName") String csvFileName) {
        //TODO More to be added
        switch (csvFileName) {
            case SERVICE_REQUESTS_ABANDONED_VEHICLES:
                break;
            default: //alley-lights-out, street-lights-all-out, street-lights-one-out
                return parseAndSaveServiceRequests(csvFileName);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private ResponseEntity parseAndSaveServiceRequests(String csvFileName) {
        if (RUNNING_ALREADY) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
        RUNNING_ALREADY = Boolean.TRUE;
        new Thread(() -> {
            Path path = new File(csvBaseFolder.concat(csvFileName).concat(CSV_FILE_EXTENSION)).toPath();
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }

            HeaderColumnNameMappingStrategy<ServiceRequestCsv> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(ServiceRequestCsv.class);
            CsvToBean csvToBean = new CsvToBeanBuilder(Objects.requireNonNull(bufferedReader))
                    .withType(ServiceRequestCsv.class)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<ServiceRequestCsv> serviceRequestCsvList = csvToBean.parse();

            serviceRequestCsvList
                    .stream()
                    .map(serviceRequestCsv -> serviceRequestCsvToServiceRequest.apply(serviceRequestCsv))
                    .forEach(serviceRequestRepository::save);
            RUNNING_ALREADY = Boolean.FALSE;
        }).start();
        return ResponseEntity.ok().build();
    }
}
