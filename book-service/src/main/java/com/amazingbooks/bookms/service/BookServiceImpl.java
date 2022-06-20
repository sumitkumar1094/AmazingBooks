package com.amazingbooks.bookms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.amazingbooks.bookms.model.Book;
import com.amazingbooks.bookms.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book fetch(Integer id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Book book) {
		bookRepository.save(book);
	}

	@Override
	public Book edit(Book book) {
		Book dbBook = this.fetch(book.getIsbn());
		if(book.getIsbn() != null) {
			dbBook.setIsbn(book.getIsbn());
		}
		if(book.getAuthor() != null) {
			dbBook.setAuthor(book.getAuthor());
		}
		if(book.getTitle() != null) {
			dbBook.setTitle(book.getTitle());
		}
		if(book.getPublisedDate() != null) {
			dbBook.setPublisedDate(book.getPublisedDate());
		}
		if(book.getIssuedCopies() != null) {
			dbBook.setIssuedCopies(book.getIssuedCopies());
		}
		if(book.getTotalCopies() != null) {
			dbBook.setTotalCopies(book.getTotalCopies());
		}
		bookRepository.save(dbBook);
		return dbBook;
	}

	@Override
	public String delete(Integer id) {
		try {
			bookRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException ex) {
			return "Book not found with id : " + id;
		}
		return "Book has been deleted.";
	}

	@Override
	public List<Book> fetchAll() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(book -> books.add(book));
		return books;
	}

	@Override
	public List<Integer> saveAll(List<Book> books) {
		List<Integer> isbns = new ArrayList<>();
		bookRepository.saveAll(books);
		books.forEach(book -> isbns.add(book.getIsbn()));
		return isbns;
	}
}
