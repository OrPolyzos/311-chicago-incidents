package com.uoa.di.csr.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.uoa.di.csr.converter.service_request.AbandonedVehicleCsvToAbandonedVehicleRequest;
import com.uoa.di.csr.converter.service_request.GarbageCartCsvToGarbageCartRequest;
import com.uoa.di.csr.converter.service_request.RodentBaitingCsvToRodentBaitingRequest;
import com.uoa.di.csr.converter.service_request.ServiceRequestCsvToServiceRequest;
import com.uoa.di.csr.parser.model.AbandonedVehicleCsv;
import com.uoa.di.csr.parser.model.GarbageCartCsv;
import com.uoa.di.csr.parser.model.RodentBaitingCsv;
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
    private static final String SERVICE_REQUESTS_GARBAGE_CARTS = "311-service-requests-garbage-carts";
    private static final String SERVICE_REQUESTS_RODENT_BAITING = "311-service-requests-rodent-baiting";
    private static final String SERVICE_REQUESTS_POT_HOLES_REPORTED = "311-service-requests-pot-holes-reported";

    private static String CSV_FILE_EXTENSION = ".csv";

    private static Boolean RUNNING_ALREADY = Boolean.FALSE;

    @Value("${csr.csv.files.base.folder}")
    private String csvBaseFolder;


    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Autowired
    private AbandonedVehicleCsvToAbandonedVehicleRequest abandonedVehicleCsvToAbandonedVehicleRequest;

    @Autowired
    private GarbageCartCsvToGarbageCartRequest garbageCartCsvToGarbageCartRequest;

    @Autowired
    private RodentBaitingCsvToRodentBaitingRequest rodentBaitingCsvToRodentBaitingRequest;

    @GetMapping("load-service-requests/{csvFileName}")
    public ResponseEntity loadServiceRequests(@PathVariable("csvFileName") String csvFileName) {
        if (RUNNING_ALREADY) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
        new Thread(() -> {
            try {
                //TODO ALL DISTINCT TYPES SHOULD BE ADDED
                switch (csvFileName) {
                    case SERVICE_REQUESTS_ABANDONED_VEHICLES:
                        List<AbandonedVehicleCsv> abandonedVehicleCsvList = parseAndSaveServiceRequests(csvFileName, AbandonedVehicleCsv.class).parse();
                        abandonedVehicleCsvList
                                .stream()
                                .map(abandonedVehicleCsv -> abandonedVehicleCsvToAbandonedVehicleRequest.apply(abandonedVehicleCsv))
                                .forEach(serviceRequestRepository::save);

                        break;
                    case SERVICE_REQUESTS_GARBAGE_CARTS:
                        List<GarbageCartCsv> garbageCartCsvList = parseAndSaveServiceRequests(csvFileName, GarbageCartCsv.class).parse();
                        garbageCartCsvList
                                .stream()
                                .map(garbageCartCsv -> garbageCartCsvToGarbageCartRequest.apply(garbageCartCsv))
                                .forEach(serviceRequestRepository::save);
                        break;
                    case SERVICE_REQUESTS_RODENT_BAITING:
                        List<RodentBaitingCsv> rodentBaitingCsvList = parseAndSaveServiceRequests(csvFileName, RodentBaitingCsv.class).parse();
                        rodentBaitingCsvList
                                .stream()
                                .map(rodentBaitingCsv -> rodentBaitingCsvToRodentBaitingRequest.apply(rodentBaitingCsv))
                                .forEach(serviceRequestRepository::save);
                    default: //alley-lights-out, street-lights-all-out, street-lights-one-out
                        List<ServiceRequestCsv> serviceRequestCsvList = parseAndSaveServiceRequests(csvFileName, ServiceRequestCsv.class).parse();
                        serviceRequestCsvList
                                .stream()
                                .map(serviceRequestCsv -> serviceRequestCsvToServiceRequest.apply(serviceRequestCsv))
                                .forEach(serviceRequestRepository::save);
                }
            } finally {
                RUNNING_ALREADY = Boolean.FALSE;
            }
        }).start();
        return ResponseEntity.ok().build();
    }

    @SuppressWarnings("unchecked")
    private CsvToBean parseAndSaveServiceRequests(String csvFileName, Class csvClass) {
        Path path = new File(csvBaseFolder.concat(csvFileName).concat(CSV_FILE_EXTENSION)).toPath();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HeaderColumnNameMappingStrategy<ServiceRequestCsv> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(csvClass);
        return new CsvToBeanBuilder(Objects.requireNonNull(bufferedReader))
                .withType(csvClass)
                .withMappingStrategy(strategy)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
    }
}
