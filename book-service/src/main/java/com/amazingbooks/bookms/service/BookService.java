package com.amazingbooks.bookms.service;

import java.util.List;

import com.amazingbooks.bookms.model.Book;

public interface BookService {
	
	public Book fetch(Integer id);
	
	public List<Book> fetchAll();
	
	public void saveOrUpdate(Book book);
	
	public List<Integer> saveAll(List<Book> books);
	
	public Book edit(Book book);
	
	public String delete(Integer id);
}
