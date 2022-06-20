package com.amazingbooks.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazingbooks.customer.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByEmailId(String emailId);
	
	Boolean existsByEmailId(String emailId);
}
