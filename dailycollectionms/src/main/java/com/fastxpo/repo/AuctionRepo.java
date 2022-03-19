package com.fastxpo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastxpo.bean.Auction;

public interface AuctionRepo extends JpaRepository<Auction, Long> {

}
