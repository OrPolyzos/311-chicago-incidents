package com.uoa.di.csr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.uoa.di.csr.security.SecurityHelper.*;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private SecurityHelper securityHelper;

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        if (securityHelper.checkForRole(authentication, ADMIN_ROLE)) {
            redirectToSuccessUrl(request, response, ADMIN_SUCCESS_URL);
        } else {
            redirectToSuccessUrl(request, response, USER_SUCCESS_URL);
        }
    }

    private void redirectToSuccessUrl(HttpServletRequest request, HttpServletResponse response, String success_url) throws IOException {
        RedirectStrategy redirectStrategy = super.getRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, success_url);
    }
}
