package com.uoa.di.csr.controller.user;

import com.uoa.di.csr.controller.BaseController;
import com.uoa.di.csr.converter.service_request.AbandonedVehicleCsvToAbandonedVehicleRequest;
import com.uoa.di.csr.domain.AbandonedVehicleRequest;
import com.uoa.di.csr.domain.ServiceRequestType;
import com.uoa.di.csr.parser.model.AbandonedVehicleCsv;
import com.uoa.di.csr.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.uoa.di.csr.security.SecurityHelper.USER_BASE_URI;

@Controller
@RequestMapping(USER_BASE_URI)
public class AbandonedVehicleController extends BaseController {

    private static final String URI = "/abandoned-vehicle";
    private static final String VIEW = "/user/service-request/create/abandoned-vehicle";

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private AbandonedVehicleCsvToAbandonedVehicleRequest mapper;

    @GetMapping(URI)
    public String getView(Model model) {
        addCreateForm(model, new AbandonedVehicleCsv());
        return VIEW;
    }

    @PostMapping(URI)
    public String processCreation(Model model, @Valid @ModelAttribute(CREATE_FORM) AbandonedVehicleCsv createForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return processForErrors(createForm, URI, bindingResult, redirectAttributes);
        }
        createForm.setServiceRequestType(ServiceRequestType.ABANDONED_VEHICLE_COMPLAINT.getValue());
        createForm.setCreationDateTime(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));

        AbandonedVehicleRequest serviceRequest = mapper.apply(createForm);
        serviceRequestRepository.save(serviceRequest);
        return redirectToUri(USER_BASE_URI + URI);
    }

}
