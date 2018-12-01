package com.uoa.di.csr.controller.user;

import com.uoa.di.csr.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.uoa.di.csr.security.SecurityHelper.USER_BASE_URI;

@Controller
@RequestMapping(USER_BASE_URI)
public class ServiceRequestController {

    public static final String SERVICE_REQUESTS_URI = "/service-requests";

    private static final String SERVICE_REQUESTS_VIEW = "user/service-request/service-requests";

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @GetMapping(SERVICE_REQUESTS_URI)
    public String getServiceRequestsView(Model model) {
        model.addAttribute("serviceRequests", serviceRequestRepository.findAll(new PageRequest(0,200)).getContent());
        return SERVICE_REQUESTS_VIEW;
    }
}
