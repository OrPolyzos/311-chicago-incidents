package com.uoa.di.csr.exception.service_request;


import com.uoa.di.csr.exception.CsrException;

public class ServiceRequestDataInconsistencyException extends CsrException {

    private static final String INCONSISTENCY_EXCEPTION_MESSAGE = "Data inconsistency on ServiceRequest with id: %s";

    public ServiceRequestDataInconsistencyException(Long srId) {
        super(String.format(INCONSISTENCY_EXCEPTION_MESSAGE, srId));
    }
}
