package com.fastxpo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastxpo.model.Partner;
import com.fastxpo.repository.PartnerRepository;
@Service
public class PartnerServiceImplemention implements PartnerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PartnerServiceImplemention.class);
	
	@Autowired
	private PartnerRepository partnerRepository;

	@Override
	public Partner savePartner( @Valid Partner partner) {
	
		LOGGER.info("Creating partner",partner);
		
		Long CID = partnerRepository.getPartnerByMobile(partner.getMobile());
		if (null != CID) {
			LOGGER.info("Customer Already Exist" + partner.getMobile());
			partner.setApistatus("1");
			partner.setApimsg("Customer Already Exist");
			partner.setPartnerId(CID);
		}else {
			partnerRepository.save(partner);
			System.out.println("partnerID::"+partner.getPartnerId());
		}
		
		return partner;
	}
		
		
	}


