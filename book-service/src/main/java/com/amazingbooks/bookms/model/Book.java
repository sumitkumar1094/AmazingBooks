/**
 * Model for Books
 * @author sumit
 */
package com.amazingbooks.bookms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "BOOKS")
@Entity
public class Book {
	
	@Id
	@Column(name = "ISBN_NUMBER")
	@NotNull
	@Min(value = 1)
	//Standard book number
	private Integer isbn;
	
	@Column(name = "TITLE")
	@NotNull
	//Title of the book
	private String title;
	
	@Column(name = "PUBLISHED_DATE")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	//Date of publication of book
	private Date publishedDate;
	
	@Column(name = "AUTHOR")
	@NotNull
	//Author of the book
	private String author;
	
	@Column(name = "ISSUED_COPIES")
	//Number of issued copies
	private Integer issuedCopies;
	
	@Column(name = "TOTAL_COPIES")
	//Number of total books
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
		return publishedDate;
	}

	public void setPublisedDate(Date publisedDate) {
		this.publishedDate = publisedDate;
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
