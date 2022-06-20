package com.amazingbooks.customer.service;

import com.amazingbooks.customer.model.Customer;

public interface CustomerService {
	
	public Boolean check(String emailId);
	
	public void signUp(Customer customer);
}
