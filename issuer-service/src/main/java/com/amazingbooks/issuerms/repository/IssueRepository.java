package com.amazingbooks.issuerms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amazingbooks.issuerms.model.IssueOrders;

public interface IssueRepository extends JpaRepository<IssueOrders, Integer>{

}
