package com.fastxpo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fastxpo.bean.Auction;
import com.fastxpo.bean.Chit;
import com.fastxpo.bean.Due;
import com.fastxpo.bean.Payment;
import com.fastxpo.bean.People;

public interface ChitService {

	public Chit saveOrUpdateChit(@NotNull @Valid final Chit chit);

	public People saveOrUpdatePeople(@NotNull @Valid final People people);

	public Due saveOrUpdateDue(@NotNull @Valid final Due due);
	
	public Auction saveOrUpdateAuction(@NotNull @Valid final Auction auction);
		
	public Payment saveOrUpdatePayment(@NotNull @Valid final Payment payment);
	
	public Auction updateAuctionWithDues(@NotNull @Valid final Auction auction) ;
	
	public Auction updateAuctionStatus(@NotNull @Valid final Auction auction);
	

}
