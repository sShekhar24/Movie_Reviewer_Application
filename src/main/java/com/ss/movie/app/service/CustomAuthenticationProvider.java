package com.ss.movie.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	class BadCredentialsException extends AuthenticationException{
		public BadCredentialsException(String message) {
			super(message);
		}
		
	}

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		if(validateAuthentication(username, password)) {
			return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
		}
		throw new BadCredentialsException("Wrong Password");
		
	}

	private boolean validateAuthentication(String username, String password) {
		return userDetailsService.loadUserByUsername(username).getPassword().equals(password);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
