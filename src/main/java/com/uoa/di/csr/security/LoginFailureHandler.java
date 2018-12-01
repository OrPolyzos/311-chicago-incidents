package com.uoa.di.csr.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.uoa.di.csr.security.SecurityHelper.LOGIN_URI;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public static final String ERROR_URI_PARAM = "error";
    public static final String ERROR_URI = LOGIN_URI + "?" + ERROR_URI_PARAM + "=true";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        RedirectStrategy redirectStrategy = super.getRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, ERROR_URI);
    }
}