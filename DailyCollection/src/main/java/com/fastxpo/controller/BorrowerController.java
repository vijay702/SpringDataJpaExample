package com.fastxpo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastxpo.model.Borrower;
import com.fastxpo.service.BorrowerService;

@RestController
public class BorrowerController {
	@Autowired
	private BorrowerService borrowerService;
	
	@PostMapping("/borrower.htm")
	public Borrower saveBorrower(@RequestBody Borrower borrower) {
		
		
		return borrowerService.saveBorrower(borrower);
		
	}
	
	

}
