package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.domain.TreeDebrisRequest;
import com.uoa.di.csr.parser.model.TreeDebrisCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TreeDebrisCsvToTreeDebrisRequest implements Function<TreeDebrisCsv, TreeDebrisRequest> {

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public TreeDebrisRequest apply(TreeDebrisCsv treeDebrisCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(treeDebrisCsv);
        TreeDebrisRequest treeDebrisRequest = new TreeDebrisRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, treeDebrisRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        treeDebrisRequest.setWhereIsTheDebrisLocated(serviceRequestCsvToServiceRequest.mapToOptional(treeDebrisCsv.getWhereIsDebrisLocated()).isPresent() ? treeDebrisCsv.getWhereIsDebrisLocated() : null);

        serviceRequestCsvToServiceRequest.manageActivityIfExists(treeDebrisCsv, treeDebrisRequest);
        serviceRequestCsvToServiceRequest.manageSsaIfExists(treeDebrisCsv, treeDebrisRequest);
        return treeDebrisRequest;
    }

}
