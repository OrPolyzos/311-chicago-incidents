package com.uoa.di.csr.service;

import com.uoa.di.csr.domain.SpecialServiceArea;
import com.uoa.di.csr.repository.SpecialServiceAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialAreaService {

    @Autowired
    private SpecialServiceAreaRepository specialServiceAreaRepository;

    public SpecialServiceArea save(SpecialServiceArea specialServiceAreaToInsert) {
        if (specialServiceAreaToInsert.getSsa() == null) {
            return null;
        }
        Optional<SpecialServiceArea> specialServiceArea = specialServiceAreaRepository.findBySsa(specialServiceAreaToInsert.getSsa());
        return specialServiceArea.orElseGet(() -> specialServiceAreaRepository.save(specialServiceAreaToInsert));
    }

}
