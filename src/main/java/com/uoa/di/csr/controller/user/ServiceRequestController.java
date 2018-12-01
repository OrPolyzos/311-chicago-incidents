package com.uoa.di.csr.controller.user;

import com.uoa.di.csr.domain.ServiceRequestType;
import com.uoa.di.csr.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.Month;

import static com.uoa.di.csr.security.SecurityHelper.USER_BASE_URI;

@Controller
@RequestMapping(USER_BASE_URI)
public class ServiceRequestController {

    public static final String SERVICE_REQUESTS_URI = "/service-requests";
    public static final String STORED_FUNCTION_ONE_URI = "/sf/1";
    public static final String STORED_FUNCTION_TWO_URI = "/sf/2";
    public static final String STORED_FUNCTION_THREE_URI = "/sf/3";

    private static final String SERVICE_REQUESTS_VIEW = "user/service-request/service-requests";
    public static final String STORED_FUNCTION_ONE_VIEW = "user/stored-functions/one";
    public static final String STORED_FUNCTION_TWO_VIEW = "user/stored-functions/two";
    public static final String STORED_FUNCTION_THREE_VIEW = "user/stored-functions/three";

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @GetMapping(SERVICE_REQUESTS_URI)
    public String getServiceRequestsView(Model model) {
        model.addAttribute("serviceRequests", serviceRequestRepository.findAll(new PageRequest(0, 200)).getContent());
        return SERVICE_REQUESTS_VIEW;
    }

    //TODO SUPPLY ARGUMENTS FROM THE UI
    @GetMapping(STORED_FUNCTION_ONE_URI)
    public String getStoredFunctionOneView(Model model) {
        model.addAttribute("results", serviceRequestRepository.getTotalRequestsPerTypeInRange(LocalDateTime.now().minusMonths(100), LocalDateTime.now()));
        return STORED_FUNCTION_ONE_VIEW;
    }

    @GetMapping(STORED_FUNCTION_TWO_URI)
    public String getStoredFunctionTwoView(Model model) {
        model.addAttribute("results", serviceRequestRepository.getTotalRequestsPerDayWithTypeInRange(ServiceRequestType.ALLEY_LIGHT_OUT, LocalDateTime.now().minusMonths(100), LocalDateTime.now()));
        return STORED_FUNCTION_TWO_VIEW;
    }

    @GetMapping(STORED_FUNCTION_THREE_URI)
    public String getStoredFunctionThreeView(Model model) {
        model.addAttribute("results", serviceRequestRepository.getMostCommonRequestTypesPerZipCodeForDay(LocalDateTime.of(2011, Month.JANUARY, 1, 0, 0, 0)));
        return STORED_FUNCTION_THREE_VIEW;
    }
}
