package com.fastxpo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastxpo.model.Borrower;
import com.fastxpo.repository.BorrowerRepository;

@Service
public class BorrowerServiceImpl implements BorrowerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BorrowerServiceImpl.class);
	
	@Autowired
	private BorrowerRepository borrowerRepository;

	@Override
	public Borrower saveBorrower(Borrower borrower) {	
			 
	borrowerRepository.save(borrower);
			
				
	
		return borrower;
	}
	

}
