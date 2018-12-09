package com.uoa.di.csr.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.uoa.di.csr.converter.service_request.AbandonedVehicleCsvToAbandonedVehicleRequest;
import com.uoa.di.csr.converter.service_request.GarbageCartCsvToGarbageCartRequest;
import com.uoa.di.csr.converter.service_request.GraffitiRemovalCsvToGraffitiRemovalRequest;
import com.uoa.di.csr.converter.service_request.PotHoleCsvToPotHoleRequest;
import com.uoa.di.csr.converter.service_request.RodentBaitingCsvToRodentBaitingRequest;
import com.uoa.di.csr.converter.service_request.SanitationCodeCsvToSanitationCodeRequest;
import com.uoa.di.csr.converter.service_request.ServiceRequestCsvToServiceRequest;
import com.uoa.di.csr.converter.service_request.TreeDebrisCsvToTreeDebrisRequest;
import com.uoa.di.csr.converter.service_request.TreeTrimsCsvToTreeTrimsRequest;
import com.uoa.di.csr.parser.model.AbandonedVehicleCsv;
import com.uoa.di.csr.parser.model.GarbageCartCsv;
import com.uoa.di.csr.parser.model.GraffitiRemovalCsv;
import com.uoa.di.csr.parser.model.PotHoleCsv;
import com.uoa.di.csr.parser.model.RodentBaitingCsv;
import com.uoa.di.csr.parser.model.SanitationCodeCsv;
import com.uoa.di.csr.parser.model.ServiceRequestCsv;
import com.uoa.di.csr.parser.model.TreeDebrisCsv;
import com.uoa.di.csr.parser.model.TreeTrimsCsv;
import com.uoa.di.csr.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@Component
public class SpecificServiceRequestResolver {

    private static final String ABANDONED_VEHICLES = "abandoned-vehicles";
    private static final String GARBAGE_CARTS = "garbage-carts";
    private static final String RODENT_BAITING = "rodent-baiting";
    private static final String POT_HOLES = "pot-holes";
    private static final String GRAFFITI_REMOVAL = "graffiti-removal";
    private static final String TREE_DEBRIS = "tree-debris";
    private static final String TREE_TRIMS = "tree-trims";
    private static final String SANITATION_CODE = "sanitation-code";

    private static String CSV_FILE_EXTENSION = ".csv";

    private static Boolean RUNNING_ALREADY = Boolean.FALSE;

    @Value("${csr.csv.files.base.folder}")
    private String csvBaseFolder;

    private final ServiceRequestRepository serviceRequestRepository;
    private final ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    private final AbandonedVehicleCsvToAbandonedVehicleRequest abandonedVehicleCsvToAbandonedVehicleRequest;
    private final GarbageCartCsvToGarbageCartRequest garbageCartCsvToGarbageCartRequest;
    private final PotHoleCsvToPotHoleRequest potHoleCsvToPotHoleRequest;
    private final RodentBaitingCsvToRodentBaitingRequest rodentBaitingCsvToRodentBaitingRequest;
    private final GraffitiRemovalCsvToGraffitiRemovalRequest graffitiRemovalCsvToGraffitiRemovalRequest;
    private final TreeDebrisCsvToTreeDebrisRequest treeDebrisCsvToTreeDebrisRequest;
    private final TreeTrimsCsvToTreeTrimsRequest treeTrimsCsvToTreeTrimsRequest;
    private final SanitationCodeCsvToSanitationCodeRequest sanitationCodeCsvToSanitationCodeRequest;

    public SpecificServiceRequestResolver(ServiceRequestRepository serviceRequestRepository, ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest,
                                          AbandonedVehicleCsvToAbandonedVehicleRequest abandonedVehicleCsvToAbandonedVehicleRequest,
                                          GarbageCartCsvToGarbageCartRequest garbageCartCsvToGarbageCartRequest,
                                          PotHoleCsvToPotHoleRequest potHoleCsvToPotHoleRequest,
                                          RodentBaitingCsvToRodentBaitingRequest rodentBaitingCsvToRodentBaitingRequest,
                                          GraffitiRemovalCsvToGraffitiRemovalRequest graffitiRemovalCsvToGraffitiRemovalRequest,
                                          TreeDebrisCsvToTreeDebrisRequest treeDebrisCsvToTreeDebrisRequest,
                                          TreeTrimsCsvToTreeTrimsRequest treeTrimsCsvToTreeTrimsRequest,
                                          SanitationCodeCsvToSanitationCodeRequest sanitationCodeCsvToSanitationCodeRequest) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.serviceRequestCsvToServiceRequest = serviceRequestCsvToServiceRequest;
        this.abandonedVehicleCsvToAbandonedVehicleRequest = abandonedVehicleCsvToAbandonedVehicleRequest;
        this.garbageCartCsvToGarbageCartRequest = garbageCartCsvToGarbageCartRequest;
        this.potHoleCsvToPotHoleRequest = potHoleCsvToPotHoleRequest;
        this.rodentBaitingCsvToRodentBaitingRequest = rodentBaitingCsvToRodentBaitingRequest;
        this.graffitiRemovalCsvToGraffitiRemovalRequest = graffitiRemovalCsvToGraffitiRemovalRequest;
        this.treeDebrisCsvToTreeDebrisRequest = treeDebrisCsvToTreeDebrisRequest;
        this.treeTrimsCsvToTreeTrimsRequest = treeTrimsCsvToTreeTrimsRequest;
        this.sanitationCodeCsvToSanitationCodeRequest = sanitationCodeCsvToSanitationCodeRequest;
    }


    @SuppressWarnings("unchecked")
    public ResponseEntity<String> parseCsv(String csvFileName) {
        if (RUNNING_ALREADY) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
        new Thread(() -> {
            try {
                switch (csvFileName) {
                    case ABANDONED_VEHICLES:
                        List<AbandonedVehicleCsv> abandonedVehicleCsvList = parseAndSaveServiceRequests(csvFileName, AbandonedVehicleCsv.class).parse();
                        abandonedVehicleCsvList
                                .stream()
                                .map(abandonedVehicleCsvToAbandonedVehicleRequest)
                                .forEach(serviceRequestRepository::save);

                        break;
                    case GARBAGE_CARTS:
                        List<GarbageCartCsv> garbageCartCsvList = parseAndSaveServiceRequests(csvFileName, GarbageCartCsv.class).parse();
                        garbageCartCsvList
                                .stream()
                                .map(garbageCartCsvToGarbageCartRequest)
                                .forEach(serviceRequestRepository::save);
                        break;
                    case RODENT_BAITING:
                        List<RodentBaitingCsv> rodentBaitingCsvList = parseAndSaveServiceRequests(csvFileName, RodentBaitingCsv.class).parse();
                        rodentBaitingCsvList
                                .stream()
                                .map(rodentBaitingCsvToRodentBaitingRequest)
                                .forEach(serviceRequestRepository::save);
                        break;
                    case POT_HOLES:
                        List<PotHoleCsv> potHoleCsvList = parseAndSaveServiceRequests(csvFileName, PotHoleCsv.class).parse();
                        potHoleCsvList
                                .stream()
                                .map(potHoleCsvToPotHoleRequest)
                                .forEach(serviceRequestRepository::save);
                        break;
                    case GRAFFITI_REMOVAL:
                        List<GraffitiRemovalCsv> graffitiRemovalCsvList = parseAndSaveServiceRequests(csvFileName, GraffitiRemovalCsv.class).parse();
                        graffitiRemovalCsvList
                                .stream()
                                .map(graffitiRemovalCsvToGraffitiRemovalRequest)
                                .forEach(serviceRequestRepository::save);
                        break;
                    case TREE_DEBRIS:
                        List<TreeDebrisCsv> treeDebrisCsvList = parseAndSaveServiceRequests(csvFileName, TreeDebrisCsv.class).parse();
                        treeDebrisCsvList
                                .stream()
                                .map(treeDebrisCsvToTreeDebrisRequest)
                                .forEach(serviceRequestRepository::save);
                        break;
                    case TREE_TRIMS:
                        List<TreeTrimsCsv> treeTrimsCsvList = parseAndSaveServiceRequests(csvFileName, TreeTrimsCsv.class).parse();
                        treeTrimsCsvList
                                .stream()
                                .map(treeTrimsCsvToTreeTrimsRequest)
                                .forEach(serviceRequestRepository::save);
                        break;
                    case SANITATION_CODE:
                        List<SanitationCodeCsv> sanitationCodeCsvList = parseAndSaveServiceRequests(csvFileName, SanitationCodeCsv.class).parse();
                        sanitationCodeCsvList
                                .stream()
                                .map(sanitationCodeCsvToSanitationCodeRequest)
                                .forEach(serviceRequestRepository::save);
                        break;
                    default: //alley-lights-out, street-lights-all-out, street-lights-one-out
                        List<ServiceRequestCsv> serviceRequestCsvList = parseAndSaveServiceRequests(csvFileName, ServiceRequestCsv.class).parse();
                        serviceRequestCsvList
                                .stream()
                                .map(serviceRequestCsvToServiceRequest)
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
