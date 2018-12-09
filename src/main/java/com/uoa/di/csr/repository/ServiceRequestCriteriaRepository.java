package com.uoa.di.csr.repository;

import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.model.search.GeneralSearchForm;

import java.util.List;

public interface ServiceRequestCriteriaRepository {

    List<ServiceRequest> criteriaSearch(GeneralSearchForm searchForm);

}
