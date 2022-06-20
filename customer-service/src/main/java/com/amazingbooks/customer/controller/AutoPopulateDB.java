package com.amazingbooks.customer.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.amazingbooks.customer.model.Customer;
import com.amazingbooks.customer.model.Role;
import com.amazingbooks.customer.repository.RoleRepository;
import com.amazingbooks.customer.service.CustomerService;

@Component
public class AutoPopulateDB {
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RoleRepository roleRepository;
	/*
	 * Method to generate some defaults database entries
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void createRoles() {
		Role role = new Role("USER");
		roleRepository.save(role);
		role = new Role("ADMIN");
		roleRepository.save(role);
		Customer admin = new Customer();
		admin.setEmailId("admin@gmail.com");
		admin.setPassword(encoder.encode("admin"));
		role = roleRepository.findByName("ADMIN")
				.orElseThrow(() -> new RuntimeException("No role found as 'ADMIN'."));
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		admin.setRoles(roles);
		customerService.signUp(admin);
	}
}
