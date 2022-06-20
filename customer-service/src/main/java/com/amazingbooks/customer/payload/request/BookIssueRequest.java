package com.amazingbooks.customer.payload.request;

public class BookIssueRequest {
	
	private Integer isbn;
	private Integer numofCopies;
	
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public Integer getNumofCopies() {
		return numofCopies;
	}
	public void setNumofCopies(Integer numofCopies) {
		this.numofCopies = numofCopies;
	}
}
