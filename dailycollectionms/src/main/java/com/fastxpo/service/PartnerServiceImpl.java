package com.fastxpo.service;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.fastxpo.bean.Partner;
import com.fastxpo.repo.PartnerRepo;



@Service
@Validated
public class PartnerServiceImpl implements PartnerService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PartnerServiceImpl.class);

	@Autowired
	private PartnerRepo partnerRepo;

	@Override
	@Transactional
	public Partner save(@NotNull @Valid final Partner partner) {
		return partnerRepo.save(partner);
}

	@Override
	@Transactional
	public Partner signUp(@NotNull @Valid final Partner partner) {
		LOGGER.debug("Creating {}",partner);
		Long CID = partnerRepo.getPartnerByMobile(partner.getMobile());
		if (null != CID) {
			LOGGER.info("Customer Already Exist" + partner.getMobile());
			partner.setApistatus("1");
			partner.setApimsg("Customer Already Exist");
			partner.setPartnerid(CID);
		}else {
			partnerRepo.save(partner);
			System.out.println("partnerID::"+partner.getPartnerid());
		}
		//partner.setCreatedate(new Date());
		return partner;
	}
	

	@Override
	@Transactional
	public Partner login(@NotNull @Valid  Partner partner) {
		try {
		LOGGER.debug("Creating {}",partner);
		System.out.println("partner::"+partner.getMobile()+",,"+partner.getPassword());
		Partner partnerResp = partnerRepo.loginCheckByUserAndPassword(partner.getMobile(),partner.getPassword());
		System.out.println("partnerResp"+partnerResp);
		if (null==partnerResp) {
			LOGGER.info("Invaild User And Password" + partner.getMobile());
			partner.setApistatus("1");
			partner.setApimsg("Invaild User And Password");
			//partner.setPartnerid(CID);
		}else {
			partner=partnerResp;
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	
		return partner;
	}
}
