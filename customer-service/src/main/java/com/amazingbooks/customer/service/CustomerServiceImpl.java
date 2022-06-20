package com.amazingbooks.customer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amazingbooks.customer.model.Customer;
import com.amazingbooks.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService, UserDetailsService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Boolean check(String emailId) {
		return customerRepository.existsByEmailId(emailId);
	}

	@Override
	public void signUp(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByEmailId(emailId)
		.orElseThrow(() -> new UsernameNotFoundException("User not found with EmailID : " + emailId));
		
		return CustomerDetailsImpl.build(customer);
	}
}
