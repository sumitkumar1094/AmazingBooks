package com.amazingbooks.bookms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.amazingbooks.bookms.model.Book;
import com.amazingbooks.bookms.service.BookService;

@Component
public class AutoPopuletDB {
	
	@Autowired
	BookService bookService;
	
	/*
	 * Method to generate some defaults database entries
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void createBook() {
		Book book = new Book();
		book.setIsbn(110101);
		book.setTitle("Amazing Project");
		book.setAuthor("X. Y. Abc");
		book.setPublisedDate(new Date());
		book.setIssuedCopies(0);
		book.setTotalCopies(1000);
		bookService.saveOrUpdate(book);
	}
}
