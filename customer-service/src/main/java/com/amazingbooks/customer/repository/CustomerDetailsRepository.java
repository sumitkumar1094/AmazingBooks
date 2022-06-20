package com.amazingbooks.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazingbooks.customer.model.Customer;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<Customer, Integer>{

}
