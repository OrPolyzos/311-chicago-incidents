package com.uoa.di.csr.controller;

import com.uoa.di.csr.service.SpecificServiceRequestResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceRequestLoadController {

    @Autowired
    private SpecificServiceRequestResolver serviceRequestResolver;

    @GetMapping("load-service-requests/{csvFileName}")
    public ResponseEntity loadServiceRequests(@PathVariable("csvFileName") String csvFileName) {
        return serviceRequestResolver.parseCsv(csvFileName);
    }

}
