package com.amazingbooks.issuerms.VO;

/**
 * 
 * @author sumit
 *
 */

public class IssueRequest {
	
	private Integer isbn;
	private Integer customerId;
	private Integer numofCopies;
	
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
	public Integer getNumofCopies() {
		return numofCopies;
	}
	public void setNumofCopies(Integer numofCopies) {
		this.numofCopies = numofCopies;
	}
}
