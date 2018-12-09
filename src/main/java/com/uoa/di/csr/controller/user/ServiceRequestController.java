package com.uoa.di.csr.controller.user;

import com.uoa.di.csr.controller.BaseController;
import com.uoa.di.csr.domain.ServiceRequest;
import com.uoa.di.csr.domain.ServiceRequestType;
import com.uoa.di.csr.model.search.BoundingBoxSearchForm;
import com.uoa.di.csr.model.search.DaySearchForm;
import com.uoa.di.csr.model.search.FromTimeToTimeSearchForm;
import com.uoa.di.csr.model.search.GeneralSearchForm;
import com.uoa.di.csr.model.search.ServiceRequestTypeSearchForm;
import com.uoa.di.csr.model.search.SingleIntegerLimitSearchForm;
import com.uoa.di.csr.repository.RodentBaitingRequestRepository;
import com.uoa.di.csr.repository.ServiceRequestRepository;
import com.uoa.di.csr.service.ServiceRequestService;
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
import java.util.List;

import static com.uoa.di.csr.security.SecurityHelper.USER_BASE_URI;

@Controller
@RequestMapping(USER_BASE_URI)
public class ServiceRequestController extends BaseController {

    public static final String SERVICE_REQUESTS_URI = "/service-requests";
    private static final String STORED_FUNCTION_ONE_URI = "/sf/requests-per-type-in-range";
    private static final String STORED_FUNCTION_TWO_URI = "/sf/requests-with-type-in-range";
    private static final String STORED_FUNCTION_THREE_URI = "/sf/most-common-per-zip-for-day";
    private static final String STORED_FUNCTION_FOUR_URI = "/sf/avg-completion-time-in-range";
    private static final String STORED_FUNCTION_FIVE_URI = "/sf/most-common-in-bounding-box-for-day";
    private static final String STORED_FUNCTION_SIX_URI = "/sf/five-top-ssa-per-total-requests";
    private static final String STORED_FUNCTION_SEVEN_URI = "/sf/licence-plates-involved-in-more-than-one-requests";
    private static final String STORED_FUNCTION_EIGHT_URI = "/sf/second-most-common-vehicle-color";
    private static final String STORED_FUNCTION_NINE_URI = "/sf/premises-baited-less-than";
    private static final String STORED_FUNCTION_TEN_URI = "/sf/premises-with-garbage-less-than";
    private static final String STORED_FUNCTION_ELEVEN_URI = "/sf/premises-with-rates-less-than";

    private static final String SERVICE_REQUESTS_VIEW = "user/service-request/service-requests";
    private static final String STORED_FUNCTION_ONE_VIEW = "user/stored-functions/one";
    private static final String STORED_FUNCTION_TWO_VIEW = "user/stored-functions/two";
    private static final String STORED_FUNCTION_THREE_VIEW = "user/stored-functions/three";
    private static final String STORED_FUNCTION_FOUR_VIEW = "user/stored-functions/four";
    private static final String STORED_FUNCTION_FIVE_VIEW = "user/stored-functions/five";
    private static final String STORED_FUNCTION_SIX_VIEW = "user/stored-functions/six";
    private static final String STORED_FUNCTION_SEVEN_VIEW = "user/stored-functions/seven";
    private static final String STORED_FUNCTION_EIGHT_VIEW = "user/stored-functions/eight";
    private static final String STORED_FUNCTION_NINE_TEN_ELEVEN_VIEW = "user/service-request/nine-ten-eleven";

    private static final String RESULTS = "results";
    private static final String SEARCH_FORM = "searchForm";
    private static final String BINDING_RESULT_CONSTANT = "org.springframework.validation.BindingResult.";
    private static final String SERVICE_REQUESTS_TYPES = "serviceRequestTypes";
    private static final String RODENT_BAITING_MESSAGE_HOLDER = "rodentBaitingMessageHolder";
    private static final String NUMBER_OF_PREMISES_BAITED = "Number of Premises Baited";
    private static final String NUMBER_OF_PREMISES_WITH_GARBAGE = "Number of Premises with Garbage";
    private static final String NUMBER_OF_PREMISES_WITH_RATS = "Number of Premises with Rats";
    private static final String RODENT_BAITING_URI_HOLDER = "rodentBaitingUriHolder";

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private ServiceRequestService serviceRequestService;

    @Autowired
    private RodentBaitingRequestRepository rodentBaitingRequestRepository;

    @GetMapping(SERVICE_REQUESTS_URI)
    public String getServiceRequestsView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new GeneralSearchForm());
        }
        return SERVICE_REQUESTS_VIEW;
    }

    @PostMapping(SERVICE_REQUESTS_URI)
    public String searchForServiceRequests(Model model, @Valid @ModelAttribute(SEARCH_FORM) GeneralSearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(SERVICE_REQUESTS_URI);
        }
        List<ServiceRequest> results = serviceRequestService.findAllByIdOrStreetOrZipCode(searchForm);
        model.addAttribute(RESULTS, results);
        return SERVICE_REQUESTS_VIEW;
    }

    @GetMapping(STORED_FUNCTION_ONE_URI)
    public String getStoredFunctionOneView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new FromTimeToTimeSearchForm());
        }
        return STORED_FUNCTION_ONE_VIEW;
    }

    @PostMapping(STORED_FUNCTION_ONE_URI)
    public String processStoredFunctionOne(Model model, @Valid @ModelAttribute(SEARCH_FORM) FromTimeToTimeSearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(STORED_FUNCTION_ONE_URI);
        }
        model.addAttribute(RESULTS, serviceRequestRepository.getTotalRequestsPerTypeInRange(searchForm.getFromTime(), searchForm.getToTime()));
        return STORED_FUNCTION_ONE_VIEW;
    }

    @GetMapping(STORED_FUNCTION_TWO_URI)
    public String getStoredFunctionTwoView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new ServiceRequestTypeSearchForm());
        }
        model.addAttribute(SERVICE_REQUESTS_TYPES, ServiceRequestType.values());
        return STORED_FUNCTION_TWO_VIEW;
    }

    @PostMapping(STORED_FUNCTION_TWO_URI)
    public String processStoredFunctionTwo(Model model, @Valid @ModelAttribute(SEARCH_FORM) ServiceRequestTypeSearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(STORED_FUNCTION_TWO_URI);
        }
        model.addAttribute(SERVICE_REQUESTS_TYPES, ServiceRequestType.values());
        model.addAttribute(RESULTS, serviceRequestRepository.getTotalRequestsPerDayWithTypeInRange(ServiceRequestType.reverseValue(searchForm.getServiceRequestType()), searchForm.getFromTime(), searchForm.getToTime()));
        return STORED_FUNCTION_TWO_VIEW;
    }

    @GetMapping(STORED_FUNCTION_THREE_URI)
    public String getStoredFunctionThreeView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new DaySearchForm());
        }
        return STORED_FUNCTION_THREE_VIEW;
    }

    @PostMapping(STORED_FUNCTION_THREE_URI)
    public String processStoredFunctionThree(Model model, @Valid @ModelAttribute(SEARCH_FORM) DaySearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(STORED_FUNCTION_THREE_URI);
        }
        model.addAttribute(RESULTS, serviceRequestRepository.getMostCommonRequestTypesPerZipCodeForDay(searchForm.getTime().atStartOfDay()));
        return STORED_FUNCTION_THREE_VIEW;
    }

    @GetMapping(STORED_FUNCTION_FOUR_URI)
    public String getStoredFunctionFourView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new FromTimeToTimeSearchForm());
        }
        return STORED_FUNCTION_FOUR_VIEW;
    }

    @PostMapping(STORED_FUNCTION_FOUR_URI)
    public String processStoredFunctionFour(Model model, @Valid @ModelAttribute(SEARCH_FORM) FromTimeToTimeSearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(STORED_FUNCTION_FOUR_URI);
        }
        model.addAttribute(RESULTS, serviceRequestRepository.getAvgCompletionTimePerTypeInRange(searchForm.getFromTime(), searchForm.getToTime()));
        return STORED_FUNCTION_FOUR_VIEW;
    }

    @GetMapping(STORED_FUNCTION_FIVE_URI)
    public String getStoredFunctionFiveView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new BoundingBoxSearchForm());
        }
        return STORED_FUNCTION_FIVE_VIEW;
    }

    @PostMapping(STORED_FUNCTION_FIVE_URI)
    public String processStoredFunctionFive(Model model, @Valid @ModelAttribute(SEARCH_FORM) BoundingBoxSearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(STORED_FUNCTION_FIVE_URI);
        }
        model.addAttribute(RESULTS, serviceRequestRepository.getMostCommonRequestInBoundingBoxForDay(searchForm.getMinX(), searchForm.getMinY(), searchForm.getMaxX(), searchForm.getMaxY(), searchForm.getTime().atStartOfDay()));
        return STORED_FUNCTION_FIVE_VIEW;
    }

    @GetMapping(STORED_FUNCTION_SIX_URI)
    public String getStoredFunctionSixView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new FromTimeToTimeSearchForm());
        }
        return STORED_FUNCTION_SIX_VIEW;
    }

    @PostMapping(STORED_FUNCTION_SIX_URI)
    public String processStoredFunctionSix(Model model, @Valid @ModelAttribute(SEARCH_FORM) FromTimeToTimeSearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(STORED_FUNCTION_SIX_URI);
        }
        model.addAttribute(RESULTS, serviceRequestRepository.getTopFiveSsaInRegardToTotalNumberOfRequestsInRange(searchForm.getFromTime(), searchForm.getToTime()));
        return STORED_FUNCTION_SIX_VIEW;
    }

    @GetMapping(STORED_FUNCTION_SEVEN_URI)
    public String getStoredFunctionSevenView(Model model) {
        model.addAttribute(RESULTS, serviceRequestRepository.getLicencePlatesInvolvedInMoreThanOneRequests());
        return STORED_FUNCTION_SEVEN_VIEW;
    }

    @GetMapping(STORED_FUNCTION_EIGHT_URI)
    public String getStoredFunctionEightView(Model model) {
        model.addAttribute(RESULTS, serviceRequestRepository.getSecondMostCommonVehicleColor());
        return STORED_FUNCTION_EIGHT_VIEW;
    }

    @GetMapping(STORED_FUNCTION_NINE_URI)
    public String getStoredFunctionNineView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new SingleIntegerLimitSearchForm());
        }
        model.addAttribute(RODENT_BAITING_URI_HOLDER, STORED_FUNCTION_NINE_URI);
        model.addAttribute(RODENT_BAITING_MESSAGE_HOLDER, NUMBER_OF_PREMISES_BAITED);
        return STORED_FUNCTION_NINE_TEN_ELEVEN_VIEW;
    }

    @PostMapping(STORED_FUNCTION_NINE_URI)
    public String processStoredFunctionNine(Model model, @Valid @ModelAttribute(SEARCH_FORM) SingleIntegerLimitSearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(STORED_FUNCTION_NINE_URI);
        }
        model.addAttribute(RODENT_BAITING_MESSAGE_HOLDER, NUMBER_OF_PREMISES_BAITED);
        model.addAttribute(RODENT_BAITING_URI_HOLDER, STORED_FUNCTION_NINE_URI);
        model.addAttribute(RESULTS, rodentBaitingRequestRepository.findAllByNumberOfPremisesBaitedLessThan(searchForm.getLimit()));
        return STORED_FUNCTION_NINE_TEN_ELEVEN_VIEW;
    }

    @GetMapping(STORED_FUNCTION_TEN_URI)
    public String getStoredFunctionTenView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new SingleIntegerLimitSearchForm());
        }
        model.addAttribute(RODENT_BAITING_URI_HOLDER, STORED_FUNCTION_TEN_URI);
        model.addAttribute(RODENT_BAITING_MESSAGE_HOLDER, NUMBER_OF_PREMISES_WITH_GARBAGE);
        return STORED_FUNCTION_NINE_TEN_ELEVEN_VIEW;
    }

    @PostMapping(STORED_FUNCTION_TEN_URI)
    public String processStoredFunctionTen(Model model, @Valid @ModelAttribute(SEARCH_FORM) SingleIntegerLimitSearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(STORED_FUNCTION_TEN_URI);
        }
        model.addAttribute(RODENT_BAITING_URI_HOLDER, STORED_FUNCTION_TEN_URI);
        model.addAttribute(RODENT_BAITING_MESSAGE_HOLDER, NUMBER_OF_PREMISES_WITH_GARBAGE);
        model.addAttribute(RESULTS, rodentBaitingRequestRepository.findAllByNumberOfPremisesWithGarbageLessThan(searchForm.getLimit()));
        return STORED_FUNCTION_NINE_TEN_ELEVEN_VIEW;
    }

    @GetMapping(STORED_FUNCTION_ELEVEN_URI)
    public String getStoredFunctionElevenView(Model model) {
        if (!model.containsAttribute(SEARCH_FORM)) {
            model.addAttribute(SEARCH_FORM, new SingleIntegerLimitSearchForm());
        }
        model.addAttribute(RODENT_BAITING_URI_HOLDER, STORED_FUNCTION_ELEVEN_URI);
        model.addAttribute(RODENT_BAITING_MESSAGE_HOLDER, NUMBER_OF_PREMISES_WITH_RATS);
        return STORED_FUNCTION_NINE_TEN_ELEVEN_VIEW;
    }

    @PostMapping(STORED_FUNCTION_ELEVEN_URI)
    public String processStoredFunctionEleven(Model model, @Valid @ModelAttribute(SEARCH_FORM) SingleIntegerLimitSearchForm searchForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + SEARCH_FORM, bindingResult);
            redirectAttributes.addFlashAttribute(SEARCH_FORM, searchForm);
            return redirect(STORED_FUNCTION_ELEVEN_URI);
        }
        model.addAttribute(RODENT_BAITING_URI_HOLDER, STORED_FUNCTION_ELEVEN_URI);
        model.addAttribute(RODENT_BAITING_MESSAGE_HOLDER, NUMBER_OF_PREMISES_BAITED);
        model.addAttribute(RESULTS, rodentBaitingRequestRepository.findAllByNumberOfPremisesWithRatsLessThan(searchForm.getLimit()));
        return STORED_FUNCTION_NINE_TEN_ELEVEN_VIEW;
    }
}
