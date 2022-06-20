package com.amazingbooks.customer.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazingbooks.customer.model.Customer;
import com.amazingbooks.customer.model.Role;
import com.amazingbooks.customer.payload.request.SignUpRequest;
import com.amazingbooks.customer.payload.response.MessageResponse;
import com.amazingbooks.customer.repository.RoleRepository;
import com.amazingbooks.customer.service.CustomerService;

/**
 * 
 * @author sumit
 *
 */
@RestController
@RequestMapping("/signup")
public class SignUp {
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RoleRepository roleRepository;
	
	@PostMapping
	private ResponseEntity<?> signUp(@RequestBody SignUpRequest request) {
		if(customerService.check(request.getEmailId())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error : User already registered!"));
		}
		Customer customer = new Customer();
		customer.setEmailId(request.getEmailId());
		customer.setPassword(encoder.encode(request.getPassword()));
		Set<Role> roles = new HashSet<>();
		Role role = roleRepository.findByName("USER")
				.orElseThrow(() -> new RuntimeException("No role found!"));
		roles.add(role);
		customer.setRoles(roles);
		customerService.signUp(customer);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
