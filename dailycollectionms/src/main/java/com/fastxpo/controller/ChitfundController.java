package com.fastxpo.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastxpo.bean.Auction;
import com.fastxpo.bean.Chit;
import com.fastxpo.bean.Due;
import com.fastxpo.bean.Partner;
import com.fastxpo.bean.Payment;
import com.fastxpo.bean.People;
import com.fastxpo.service.ChitService;
import com.fastxpo.service.PartnerService;

@RestController
@RequestMapping(path = "/api")
public class ChitfundController {

	protected static final Logger log = LoggerFactory.getLogger(ChitfundController.class);

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private ChitService chitService;

	/*
	 * @Autowired protected ModelMapper pojoMapper;
	 */

	@PostMapping(path = "/chit.htm", consumes = "application/json", produces = "application/json")
	public Chit saveOrUpdateChit(@RequestBody Chit chit) throws Exception {
		Chit record = null;
		long start = System.currentTimeMillis();
		try {
			record = chitService.saveOrUpdateChit(chit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Order Req and Res : " + (end - start));
		return record;
	}

	/**@PostMapping(path = "/chit.htm", consumes = "application/json", produces = "application/json")
	public Chit saveOrUpdateChit(@RequestBody Chit chit) throws Exception {
		Chit record = null;
		long start = System.currentTimeMillis();
		try {
			record = chitService.saveOrUpdateChit(chit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Order Req and Res : " + (end - start));
		return record;
	}*/

	@PostMapping(path = "/people.htm", consumes = "application/json", produces = "application/json")
	public People saveOrUpdatePeople(@RequestBody People chit) throws Exception {
		People record = null;
		long start = System.currentTimeMillis();
		try {
			record = chitService.saveOrUpdatePeople(chit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Order Req and Res : " + (end - start));
		return record;
	}

	@PostMapping(path = "/auction.htm", consumes = "application/json", produces = "application/json")
	public Auction saveOrUpdateAuction(@RequestBody Auction chit) throws Exception {
		Auction record = null;
		long start = System.currentTimeMillis();
		try {
			record = chitService.saveOrUpdateAuction(chit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Order Req and Res : " + (end - start));
		return record;
	}
	
	@PostMapping(path = "/updateauctionstatus.htm", consumes = "application/json", produces = "application/json")
	public Auction updateAuctionStatus(@RequestBody Auction chit) throws Exception {
		Auction record = null;
		long start = System.currentTimeMillis();
		try {
			record = chitService.updateAuctionStatus(chit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Order Req and Res : " + (end - start));
		return record;
	}

	
	@PostMapping(path = "/auctionwithdues.htm", consumes = "application/json", produces = "application/json")
	public Auction saveOrUpdateAuctionDues(@RequestBody Auction chit) throws Exception {
		Auction record = null;
		long start = System.currentTimeMillis();
		try {
			record = chitService.updateAuctionWithDues(chit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Order Req and Res : " + (end - start));
		return record;
	}
	@PostMapping(path = "/due.htm", consumes = "application/json", produces = "application/json")
	public Due saveOrUpdateDue(@RequestBody Due chit) throws Exception {
		Due record = null;
		long start = System.currentTimeMillis();
		try {
			record = chitService.saveOrUpdateDue(chit);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Order Req and Res : " + (end - start));
		return record;
	}

	@PostMapping(path = "/payment.htm", consumes = "application/json", produces = "application/json")
	public Payment saveOrUpdatePayment(@RequestBody Payment input) throws Exception {
		Payment record = null;
		long start = System.currentTimeMillis();
		try {
			record = chitService.saveOrUpdatePayment(input);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Order Req and Res : " + (end - start));
		return record;
	}
	// **************************************************************************************/
	// *************WEHBHOOK_CALLS_INBOUND_from_Aggregator***********************************/
	// **************************************************************************************/

	@PostMapping(path = "/signup.htm", consumes = "application/json", produces = "application/json")
	public Partner signup(@RequestHeader(name = "x_api_token", required = false) String apiToken,
			@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
			@RequestBody Partner storeRequest) throws Exception {
		// Create resource location
		URI location = null;
		Partner partner = null;
		long start = System.currentTimeMillis();
		String resp = "";
		try {
			System.out.println("request");
			partner = partnerService.signUp(storeRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Order Req and Res : " + (end - start));
		return partner;
	}

	@PostMapping(path = "/login.htm", consumes = "application/json", produces = "application/json")
	public Partner login(@RequestHeader(name = "x_api_token", required = false) String apiToken,
			@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
			@RequestBody Partner partner) throws Exception {
		// Create resource location
		URI location = null;

		long start = System.currentTimeMillis();
		String wID = "";
		try {
			partner = partnerService.login(partner);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Login Req and Res : " + (end - start));
		return partner;
	}
	/*
	 * Rafi
	 */

	@PostMapping(path = "/updatecompany.htm", consumes = "application/json", produces = "application/json")
	public Partner updateCompany(@RequestHeader(name = "x_api_token", required = false) String apiToken,
			@RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
			@RequestBody Partner partner) throws Exception {
		// Create resource location
		URI location = null;

		long start = System.currentTimeMillis();
		String wID = "";
		try {
			System.out.println("entering save");
			partner = partnerService.save(partner);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("Total Time Taken for Login Req and Res : " + (end - start));
		return partner;
	}

}
