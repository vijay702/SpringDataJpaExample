package com.fastxpo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.fastxpo.bean.Auction;
import com.fastxpo.bean.Chit;
import com.fastxpo.bean.Due;
import com.fastxpo.bean.Payment;
import com.fastxpo.bean.People;
import com.fastxpo.repo.AuctionRepo;
import com.fastxpo.repo.ChitRepo;
import com.fastxpo.repo.DueRepo;
import com.fastxpo.repo.PartnerRepo;
import com.fastxpo.repo.PaymentRepo;
import com.fastxpo.repo.PeopleRepo;

@Service
@Validated
public class ChitServiceImpl implements ChitService {

	@Autowired
	private PaymentRepo paymentRepo;

	@Autowired
	private PartnerRepo partnerRepo;

	@Autowired
	private ChitRepo chitRepo;

	@Autowired
	private AuctionRepo auctionRepo;

	@Autowired
	private DueRepo dueRepo;

	@Autowired
	private PeopleRepo peopleRepo;

	public Chit saveOrUpdateChit(@NotNull @Valid final Chit chit) {
		System.out.println("chitPartner" + chit.getPartner());
		System.out.println("chitPartner" + chit.getPartner().getPartnerid());

		return chitRepo.save(chit);
	}

	public People saveOrUpdatePeople(@NotNull @Valid final People people) {
		return peopleRepo.save(people);
	}

	public Due saveOrUpdateDue(@NotNull @Valid final Due due) {
		return dueRepo.save(due);
	}

	public Auction saveOrUpdateAuction(@NotNull @Valid final Auction auction) {
		System.out.println("chit" + auction.getChit());
		System.out.println("chitID" + auction.getChit().getChitid());
		Chit newChit = new Chit();
		newChit.setChitid(auction.getChit().getChitid());

		Auction resultAction = auctionRepo.save(auction);
		System.out.println("Completed DB ");
		resultAction.setChit(newChit);
		System.out.println("chit.");
		// resultAction=new Auction();

		return resultAction;

	}
	
	
	public Auction updateAuctionStatus(@NotNull @Valid final Auction auction) {
        System.out.println("auctionID::"+auction.getAuctionid());

		//Auction resultAction = auctionRepo.save(auction);
		System.out.println("Completed DB ");
	
		System.out.println("chit.");
		
		Optional<Auction> optionalA=auctionRepo.findById(auction.getAuctionid());
		Auction acutionDB=optionalA.get();
		acutionDB.setAuctionstatus(auction.getAuctionstatus());
		  auctionRepo.save(acutionDB);
			System.out.println("Completed DB ");
	
		Auction resultAction =new Auction();

		return resultAction;

	}

	public Auction updateAuctionWithDues(@NotNull @Valid final Auction auction) {
		System.out.println("Dues" + auction.getDues());
		System.out.println("auction..." + auction.getAuctionid());
		//Optional<Auction> optionalA=auctionRepo.findById(auction.getAuctionid());
		//Auction dbAuction=optionalA.get();
		List<Due> dues=auction.getDues();
		//System.out.println("dbDues"+dbAuction.getDues());
		//dbAuction.setDues(dues);
		
		List<Due> duesList=new ArrayList<Due>();
		
		//Auction resultAction = auctionRepo.save(dbAuction);
		//Auction acutionDB=new Auction();
		//acutionDB.setAuctionid(auction.getAuctionid());
		
		Optional<Auction> optionalA=auctionRepo.findById(auction.getAuctionid());
		Auction acutionDB=optionalA.get();
		List<Payment> paymentList=null;
		for(Due due: dues) {
			due.setAuction(acutionDB);
			due.setCreatedate(new Date());
			due=updatePaymentInDue(due);
			duesList.add(due);
		}
		for(Due dueDB: duesList) {
			dueRepo.save(dueDB);
		}
		System.out.println("DB Saved");
		
		
		Auction resultAction=new Auction();
		return resultAction;

	}

	public Due updatePaymentInDue(Due due) {
		List<Payment> pay1=new ArrayList<Payment>();
		Payment p1=null;
		for(Payment p: due.getPayments()) {
			p1=p;
			p1.setDue(due);
			pay1.add(p1);
		}
		due.setPayments(pay1);
		return due;
	}
	
	public Payment saveOrUpdatePayment(@NotNull @Valid final Payment payment) {
		return paymentRepo.save(payment);
	}

}
