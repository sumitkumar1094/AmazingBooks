package com.amazingbooks.issuerms.common;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author sumit
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book {
	

	private Integer isbn;
	private String title;
	private Date publisedDate;
	private String author;
	private Integer issuedCopies;
	private Integer totalCopies;
	
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublisedDate() {
		return publisedDate;
	}
	public void setPublisedDate(Date publisedDate) {
		this.publisedDate = publisedDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getIssuedCopies() {
		return issuedCopies;
	}
	public void setIssuedCopies(Integer issuedCopies) {
		this.issuedCopies = issuedCopies;
	}
	public Integer getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}
	
	
}
