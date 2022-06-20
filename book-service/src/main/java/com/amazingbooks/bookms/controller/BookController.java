package com.amazingbooks.bookms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazingbooks.bookms.model.Book;
import com.amazingbooks.bookms.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("{id}")
	private ResponseEntity<Object> fetch(@PathVariable Integer id) {
		return ResponseEntity.ok(bookService.fetch(id));
	}
	
	@GetMapping("/fetchAll")
	private ResponseEntity<List<Book>> fetchAll(){
		List<Book> books = bookService.fetchAll();
		return ResponseEntity.ok(books);
	}
	
	@PostMapping
	private ResponseEntity<Object> add(@Valid @RequestBody Book book) {
		bookService.saveOrUpdate(book);
		return ResponseEntity.status(HttpStatus.OK).body("Book has been added with ISBN : " + book.getIsbn());
	}
	
	@PostMapping("/addAll")
	private ResponseEntity<Object> addAll(@Valid @RequestBody List<Book> books) {
		List<Integer> isbns = bookService.saveAll(books);
		return ResponseEntity.status(HttpStatus.OK).body("Books has been added with ISBNs : " + isbns);
	}

	@PutMapping
	private ResponseEntity<Object> edit(@RequestBody Book book) {
		if (book.getIsbn() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ISBN can't be NULL.");
		}
		bookService.edit(book);
		return ResponseEntity.status(HttpStatus.OK).body("Book has been edited.");
	}

	@DeleteMapping("{id}")
	private ResponseEntity<Object> delete(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(bookService.delete(id));
	}
}
