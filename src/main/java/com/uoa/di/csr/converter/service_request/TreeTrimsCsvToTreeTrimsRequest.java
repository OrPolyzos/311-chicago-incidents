package com.uoa.di.csr.converter.service_request;

import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.domain.TreeTrimsRequest;
import com.uoa.di.csr.parser.model.TreeTrimsCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TreeTrimsCsvToTreeTrimsRequest implements Function<TreeTrimsCsv, TreeTrimsRequest> {

    @Autowired
    private ServiceRequestCsvToServiceRequest serviceRequestCsvToServiceRequest;

    @Override
    public TreeTrimsRequest apply(TreeTrimsCsv treeTrimsCsv) {
        ServiceRequest serviceRequest = serviceRequestCsvToServiceRequest.apply(treeTrimsCsv);
        TreeTrimsRequest treeTrimsRequest = new TreeTrimsRequest();
        serviceRequestCsvToServiceRequest.passParentValues(serviceRequest, treeTrimsRequest);
        //TODO REVISIT FOR Nullable handling - Maybe set default value to avoid nulls in database
        treeTrimsRequest.setWhereAreTreesLocated(serviceRequestCsvToServiceRequest.safeParse(treeTrimsCsv.getWhereAreTreesLocated(), Function.identity()));

        return treeTrimsRequest;
    }

}
