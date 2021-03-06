package com.fastxpo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastxpo.model.Partner;
import com.fastxpo.service.PartnerService;

@RestController
public class PartnerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PartnerController.class);
	
	@Autowired
	private PartnerService partnerService;
	
	
	@PostMapping("/signup.htm")
	public Partner savePartner(@RequestBody Partner partner ) {
		LOGGER.info("inside the save partner"+partner);
		return partnerService.savePartner(partner);
		
		
	
	}
	
	
	
	
	
	

}
