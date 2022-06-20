package com.amazingbooks.issuerms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author sumit
 *
 */

@Entity
@Table
public class IssueOrders {
	
	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column
	private Integer isbn;
	
	@Column
	private Integer customerId;
	
	@Column
	private Integer numOfCopies;

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(Integer numOfCopies) {
		this.numOfCopies = numOfCopies;
	}
	
	
}
