package com.uoa.di.csr.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ServiceRequestTypeConverter implements AttributeConverter<ServiceRequestType, String> {

    @Override
    public String convertToDatabaseColumn(ServiceRequestType serviceRequestType) {
        return serviceRequestType.getValue();
    }

    @Override
    public ServiceRequestType convertToEntityAttribute(String s) {
        return ServiceRequestType.reverseValue(s);
    }
}