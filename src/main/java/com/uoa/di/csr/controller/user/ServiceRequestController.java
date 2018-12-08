package com.uoa.di.csr.controller.user;

import com.uoa.di.csr.domain.ServiceRequestType;
import com.uoa.di.csr.model.search.BoundingBoxSearchForm;
import com.uoa.di.csr.model.search.DaySearchForm;
import com.uoa.di.csr.model.search.FromTimeToTimeSearchForm;
import com.uoa.di.csr.model.search.ServiceRequestTypeSearchForm;
import com.uoa.di.csr.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.uoa.di.csr.security.SecurityHelper.USER_BASE_URI;

@Controller
@RequestMapping(USER_BASE_URI)
public class ServiceRequestController {

    public static final String SERVICE_REQUESTS_URI = "/service-requests";
    private static final String STORED_FUNCTION_ONE_URI = "/sf/requests-per-type-in-range";
    private static final String STORED_FUNCTION_TWO_URI = "/sf/requests-with-type-in-range";
    private static final String STORED_FUNCTION_THREE_URI = "/sf/most-common-per-zip-for-day";
    private static final String STORED_FUNCTION_FOUR_URI = "/sf/avg-completion-time-in-range";
    private static final String STORED_FUNCTION_FIVE_URI = "/sf/most-common-in-bounding-box-for-day";
    private static final String STORED_FUNCTION_SIX_URI = "/sf/five-top-ssa-per-total-requests";
    private static final String STORED_FUNCTION_SEVEN_URI = "/sf/licence-plates-involved-in-more-than-one-requests";

    private static final String SERVICE_REQUESTS_VIEW = "user/service-request/service-requests";
    private static final String STORED_FUNCTION_ONE_VIEW = "user/stored-functions/one";
    private static final String STORED_FUNCTION_TWO_VIEW = "user/stored-functions/two";
    private static final String STORED_FUNCTION_THREE_VIEW = "user/stored-functions/three";
    private static final String STORED_FUNCTION_FOUR_VIEW = "user/stored-functions/four";
    private static final String STORED_FUNCTION_FIVE_VIEW = "user/stored-functions/five";
    private static final String STORED_FUNCTION_SIX_VIEW = "user/stored-functions/six";
    private static final String STORED_FUNCTION_SEVEN_VIEW = "user/stored-functions/seven";

    private static final String RESULTS = "results";
    private static final String SEARCH_FORM = "searchForm";
    private static final String SERVICE_REQUESTS_TYPES = "serviceRequestTypes";

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @GetMapping(SERVICE_REQUESTS_URI)
    public String getServiceRequestsView(Model model) {
        model.addAttribute("serviceRequests", serviceRequestRepository.findAll(new PageRequest(0, 200)).getContent());
        return SERVICE_REQUESTS_VIEW;
    }

    @GetMapping(STORED_FUNCTION_ONE_URI)
    public String getStoredFunctionOneView(Model model) {
        model.addAttribute(SEARCH_FORM, new FromTimeToTimeSearchForm());
        return STORED_FUNCTION_ONE_VIEW;
    }

    @PostMapping(STORED_FUNCTION_ONE_URI)
    public String processStoredFunctionOne(Model model, @Valid @ModelAttribute(SEARCH_FORM) FromTimeToTimeSearchForm searchForm, BindingResult bindingResult) {
        model.addAttribute(RESULTS, serviceRequestRepository.getTotalRequestsPerTypeInRange(searchForm.getFromTime(), searchForm.getToTime()));
        model.addAttribute(SEARCH_FORM, searchForm);
        return STORED_FUNCTION_ONE_VIEW;
    }

    @GetMapping(STORED_FUNCTION_TWO_URI)
    public String getStoredFunctionTwoView(Model model) {
        model.addAttribute(SEARCH_FORM, new ServiceRequestTypeSearchForm());
        model.addAttribute(SERVICE_REQUESTS_TYPES, ServiceRequestType.values());
        return STORED_FUNCTION_TWO_VIEW;
    }

    @PostMapping(STORED_FUNCTION_TWO_URI)
    public String processStoredFunctionTwo(Model model, @Valid @ModelAttribute(SEARCH_FORM) ServiceRequestTypeSearchForm searchForm, BindingResult bindingResult) {
        model.addAttribute(SEARCH_FORM, new ServiceRequestTypeSearchForm());
        model.addAttribute(SERVICE_REQUESTS_TYPES, ServiceRequestType.values());
        model.addAttribute(RESULTS, serviceRequestRepository.getTotalRequestsPerDayWithTypeInRange(ServiceRequestType.reverseValue(searchForm.getServiceRequestType()), searchForm.getFromTime(), searchForm.getToTime()));
        return STORED_FUNCTION_TWO_VIEW;
    }

    @GetMapping(STORED_FUNCTION_THREE_URI)
    public String getStoredFunctionThreeView(Model model) {
        model.addAttribute(SEARCH_FORM, new DaySearchForm());
        return STORED_FUNCTION_THREE_VIEW;
    }

    @PostMapping(STORED_FUNCTION_THREE_URI)
    public String processStoredFunctionThree(Model model, @Valid @ModelAttribute(SEARCH_FORM) DaySearchForm searchForm, BindingResult bindingResult) {
        model.addAttribute(SEARCH_FORM, new DaySearchForm());
        model.addAttribute(RESULTS, serviceRequestRepository.getMostCommonRequestTypesPerZipCodeForDay(searchForm.getTime().atStartOfDay()));
        return STORED_FUNCTION_THREE_VIEW;
    }

    @GetMapping(STORED_FUNCTION_FOUR_URI)
    public String getStoredFunctionFourView(Model model) {
        model.addAttribute(SEARCH_FORM, new FromTimeToTimeSearchForm());
        return STORED_FUNCTION_FOUR_VIEW;
    }

    @PostMapping(STORED_FUNCTION_FOUR_URI)
    public String processStoredFunctionFour(Model model, @Valid @ModelAttribute(SEARCH_FORM) FromTimeToTimeSearchForm searchForm, BindingResult bindingResult) {
        model.addAttribute(SEARCH_FORM, new FromTimeToTimeSearchForm());
        model.addAttribute(RESULTS, serviceRequestRepository.getAvgCompletionTimePerTypeInRange(searchForm.getFromTime(), searchForm.getToTime()));
        return STORED_FUNCTION_FOUR_VIEW;
    }

    @GetMapping(STORED_FUNCTION_FIVE_URI)
    public String getStoredFunctionFiveView(Model model) {
        model.addAttribute(SEARCH_FORM, new BoundingBoxSearchForm());
        return STORED_FUNCTION_FIVE_VIEW;
    }

    @PostMapping(STORED_FUNCTION_FIVE_URI)
    public String processStoredFunctionFive(Model model, @Valid @ModelAttribute(SEARCH_FORM) BoundingBoxSearchForm searchForm, BindingResult bindingResult) {
        model.addAttribute(RESULTS, serviceRequestRepository.getMostCommonRequestInBoundingBoxForDay(searchForm.getMinX(), searchForm.getMinY(), searchForm.getMaxX(), searchForm.getMaxY(), searchForm.getTime().atStartOfDay()));
        return STORED_FUNCTION_FIVE_VIEW;
    }

    @GetMapping(STORED_FUNCTION_SIX_URI)
    public String getStoredFunctionSixView(Model model) {
        model.addAttribute(SEARCH_FORM, new FromTimeToTimeSearchForm());
        return STORED_FUNCTION_SIX_VIEW;
    }

    @PostMapping(STORED_FUNCTION_SIX_URI)
    public String processStoredFunctionSix(Model model, @Valid @ModelAttribute(SEARCH_FORM) FromTimeToTimeSearchForm searchForm, BindingResult bindingResult) {
        model.addAttribute(RESULTS, serviceRequestRepository.getTopFiveSsaInRegardToTotalNumberOfRequestsInRange(searchForm.getFromTime(), searchForm.getToTime()));
        return STORED_FUNCTION_SIX_VIEW;
    }

    @GetMapping(STORED_FUNCTION_SEVEN_URI)
    public String getStoredFunctionSevenView(Model model) {
        model.addAttribute("results", serviceRequestRepository.getLicencePlatesInvolvedInMoreThanOneRequests());
        return STORED_FUNCTION_SEVEN_VIEW;
    }
}
