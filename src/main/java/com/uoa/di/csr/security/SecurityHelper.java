package com.uoa.di.csr.security;

import com.uoa.di.csr.domain.User;
import com.uoa.di.csr.exception.user.UserNotFoundException;
import com.uoa.di.csr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static com.uoa.di.csr.controller.user.ServiceRequestController.SERVICE_REQUESTS_URI;

@Component
public class SecurityHelper {

    public static final String LOGIN_URI = "/login";
    public static final String LOGOUT_URI = "/logout";

    public static final String JSESSIONID = "JSESSIONID";

    public static final String ADMIN_BASE_URI = "/admin";
    public static final String ADMIN_ROLE = "ADMIN";
    public static final String ADMIN_SUCCESS_URL = ADMIN_BASE_URI + SERVICE_REQUESTS_URI;

    public static final String USER_BASE_URI = "/user";
    public static final String USER_ROLE = "USER";
    public static final String USER_SUCCESS_URL = USER_BASE_URI + SERVICE_REQUESTS_URI;

    @Autowired
    private UserService userService;

    public boolean checkForRole(Authentication authentication, String role) {
        if (authentication != null) {
            return authentication.getAuthorities().stream()
                    .anyMatch(grantedAuth -> grantedAuth.getAuthority().equals(role));
        }
        return false;
    }

    public User getSessionUser() throws UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.findUserWithId((Long) authentication.getPrincipal());
    }
}
