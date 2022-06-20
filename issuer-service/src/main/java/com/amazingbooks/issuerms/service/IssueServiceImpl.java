package com.amazingbooks.issuerms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amazingbooks.issuerms.VO.IssueRequest;
import com.amazingbooks.issuerms.VO.IssueResponse;
import com.amazingbooks.issuerms.common.Book;
import com.amazingbooks.issuerms.model.IssueOrders;
import com.amazingbooks.issuerms.repository.IssueRepository;

/**
 * 
 * @author sumit
 *
 */

@Service
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private IssueRepository issueRepository;
	
	private String url = "http://BOOK-SERVICE/book/";

	@Override
	public IssueResponse issue(IssueRequest request) {
		
		IssueResponse response = new IssueResponse();
		Book book = template.getForObject(url + request.getIsbn(), Book.class);
		
		//Check if number of copies available
		if(book.getTotalCopies() >= request.getNumofCopies()) {
			//Update book 
			book.setIssuedCopies(book.getIssuedCopies() + request.getNumofCopies());
			book.setTotalCopies(book.getTotalCopies() - request.getNumofCopies());
			template.postForObject(url, book, String.class);
			IssueOrders order = new IssueOrders();
			order.setCustomerId(request.getCustomerId());
			order.setIsbn(request.getIsbn());
			order.setNumOfCopies(request.getNumofCopies());
			issueRepository.save(order);
			response.setMessage(request.getNumofCopies() + " copies issued to customer ID : " + request.getCustomerId());
			
		} else {
			response.setMessage("Requested number of copies are not available.");
		}
		return response;
	}
	
}
