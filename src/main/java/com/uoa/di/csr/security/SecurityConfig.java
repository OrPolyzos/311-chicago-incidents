package com.uoa.di.csr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import static com.uoa.di.csr.security.SecurityHelper.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                // make sure to grant access to any login page you are forwarding to
                .antMatchers(LOGIN_URI).permitAll()
                .antMatchers(ADMIN_BASE_URI + "/**").hasAuthority(ADMIN_ROLE)
                .antMatchers(USER_BASE_URI + "/**").hasAuthority(USER_ROLE)
                .and()
                .authenticationProvider(loginAuthenticationProvider)
                .formLogin().loginPage(LOGIN_URI).successHandler(loginSuccessHandler).failureHandler(loginFailureHandler)
                .and()
                .logout().logoutUrl(LOGOUT_URI).logoutSuccessUrl(LOGIN_URI).deleteCookies(JSESSIONID)
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl(LOGIN_URI)
                .maxSessionsPreventsLogin(false)
                .and()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .invalidSessionUrl(LOGIN_URI);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/load-service-requests/**");
    }

}

