package com.tvajjala.toggles.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {


    public CustomAuthenticationEntryPoint(final String realmName) {
        super.setRealmName(realmName);
    }

    @Override
    public void setRealmName(final String realmName) {
        super.setRealmName(realmName);
    }


    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException {
        //customize your response here
        response.addHeader("WWW-Authenticate", "Basic realm=\"TVAJJALA\"");
        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }
}
