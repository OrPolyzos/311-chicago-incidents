package com.uoa.di.csr.controller;


import com.uoa.di.csr.exception.InvalidCredentialsException;
import com.uoa.di.csr.model.LoginForm;
import com.uoa.di.csr.security.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.uoa.di.csr.messages.MessageHolders.ERROR_MESSAGE;
import static com.uoa.di.csr.security.LoginFailureHandler.ERROR_URI_PARAM;
import static com.uoa.di.csr.security.SecurityHelper.*;

@Controller
public class LoginController extends BaseController {

    private static final String LOGIN_FORM = "loginForm";
    private static final String LOGIN_VIEW = "login";

    @Autowired
    private SecurityHelper securityHelper;

    @RequestMapping(value = "/")
    public String getIndex() {
        return redirectToUri(LOGIN_URI);
    }

    @RequestMapping(value = LOGIN_URI, method = RequestMethod.GET)
    public String login(Model model, @RequestParam(name = ERROR_URI_PARAM, required = false) String error) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (securityHelper.checkForRole(authentication, ADMIN_ROLE)) {
            return redirectToUri(ADMIN_SUCCESS_URL);
        } else if (securityHelper.checkForRole(authentication, USER_ROLE)) {
            return redirectToUri(USER_SUCCESS_URL);
        }

        if (error != null) {
            model.addAttribute(ERROR_MESSAGE, InvalidCredentialsException.getInvalidCredentialsMessage());
        }

        model.addAttribute(LOGIN_FORM, new LoginForm());
        return LOGIN_VIEW;
    }
}
