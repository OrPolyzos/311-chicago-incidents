package com.uoa.di.csr.controller.user;

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

    @GetMapping(SERVICE_REQUESTS_URI)
    public String getServiceRequestsView(Model model) {


        return SERVICE_REQUESTS_VIEW;
    }
}
