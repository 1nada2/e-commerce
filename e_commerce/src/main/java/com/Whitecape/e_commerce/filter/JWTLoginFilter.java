/*package com.Whitecape.e_commerce.filter;

import java.io.IOException;
import java.util.Collections;
 
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.Whitecape.e_commerce.security.AccountCredentials;
import com.Whitecape.e_commerce.service.TokenAuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	@Autowired
	  PasswordEncoder passwordEncoder;
 
    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }
 
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
 
    	AccountCredentials creds = new ObjectMapper()
    	        .readValue(request.getInputStream(), AccountCredentials.class);
    	String s = passwordEncoder.encode(creds.getPassword());
    	    return getAuthenticationManager().authenticate(
    	        new UsernamePasswordAuthenticationToken(
    	            creds.getUsername(),
    	            s,
    	            Collections.emptyList()
    	        )
    	    );
    	  }
 
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
 
        System.out.println("JWTLoginFilter.successfulAuthentication:");
 
        // Write Authorization to Headers of Response.
        TokenAuthenticationService.addAuthentication(response, authResult.getName());
 
        String authorizationString = response.getHeader("Authorization");
 
        System.out.println("Authorization String=" + authorizationString);
    }
    @Override
    protected void successfulAuthentication(
        HttpServletRequest req,
        HttpServletResponse res, FilterChain chain,
        Authentication auth) throws IOException, ServletException {
    	System.out.println("JWTLoginFilter.successfulAuthentication:");
      TokenAuthenticationService
          .addAuthentication(res, auth.getName());
    }
 
}*/