package com.amazingbooks.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amazingbooks.customer.payload.request.SignInRequest;
import com.amazingbooks.customer.payload.response.JWTResponse;
import com.amazingbooks.customer.security.JWTUtils;
import com.amazingbooks.customer.service.CustomerDetailsImpl;

/**
 * 
 * @author sumit
 *
 */
@RestController
@RequestMapping("/signin")
public class SignIn {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTUtils jwtUtils;
	
	@Autowired
	RestTemplate template;
	
	@PostMapping
	private ResponseEntity<?> signIn(@RequestBody SignInRequest request){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmailId(), request.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		CustomerDetailsImpl customer = (CustomerDetailsImpl) authentication.getPrincipal();
		
		return ResponseEntity.ok(new JWTResponse(jwt, customer.getUsername()));
	}
}