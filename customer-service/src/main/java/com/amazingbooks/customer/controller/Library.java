package com.amazingbooks.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amazingbooks.customer.payload.request.BookIssueRequest;
import com.amazingbooks.customer.service.CustomerDetailsImpl;
import com.amazingbooks.customer.vo.issuer.IssueRequest;

/**
 * 
 * @author sumit
 *
 */
@RestController
@RequestMapping("/library")
public class Library {
	
	@Autowired
	RestTemplate template;
	
	//User authorization
	private ResponseEntity<?> authorize(){
		CustomerDetailsImpl customer = null;
		try {
			customer = (CustomerDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please login first!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
	
	@GetMapping("/allBooks")
	private ResponseEntity<?> getAllBooks(){
		ResponseEntity<?> re = authorize();
		if(re.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
			return re;
		}
		return ResponseEntity.ok(template.getForObject("http://BOOK-SERVICE/book/fetchAll", Object.class));
	}
	
	@GetMapping("/book/{id}")
	private ResponseEntity<?> getBook(@PathVariable Integer id){
		ResponseEntity<?> re = authorize();
		if(re.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
			return re;
		}
		return ResponseEntity.ok(template.getForObject("http://BOOK-SERVICE/book/" + id, Object.class));
	}
	
	@PostMapping("/issue")
	private ResponseEntity<?> issue(@RequestBody BookIssueRequest request){
		ResponseEntity<?> re = authorize();
		if(re.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
			return re;
		}
		CustomerDetailsImpl customer = (CustomerDetailsImpl) re.getBody();
		IssueRequest ir = new IssueRequest();
		ir.setCustomerId(customer.getId());
		ir.setIsbn(request.getIsbn());
		ir.setNumofCopies(request.getNumofCopies());
		return ResponseEntity.ok(template.postForObject("http://ISSUE-SERVICE/issue", ir, Object.class));
	}
	
	
	//Administrator access only
	@GetMapping("/admin")
	private ResponseEntity<?> check(){
		ResponseEntity<?> re = authorize();
		if(re.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
			return re;
		} else {
			CustomerDetailsImpl customer = (CustomerDetailsImpl) re.getBody();
			SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ADMIN");
			if(!customer.getAuthorities().contains(auth)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please log in as Admin!");
			}
		}
		return ResponseEntity.ok("Admin logged in!");
	}
}
