package com.uoa.di.csr.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class BaseController {

    protected static final String BINDING_RESULT_CONSTANT = "org.springframework.validation.BindingResult.";
    protected static final String CREATE_FORM = "srForm";

    protected static void addCreateForm(Model model, Object createForm) {
        if (!model.containsAttribute(CREATE_FORM)) {
            model.addAttribute(CREATE_FORM, createForm);
        }
    }

    protected String processForErrors(Object createForm, String uri, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(BINDING_RESULT_CONSTANT + CREATE_FORM, bindingResult);
        redirectAttributes.addFlashAttribute(CREATE_FORM, createForm);
        return redirectToUri(uri);
    }

    protected static String redirectToUri(String uri) {
        return "redirect:" + uri;
    }


}
