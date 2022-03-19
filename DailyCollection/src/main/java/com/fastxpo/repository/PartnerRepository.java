package com.fastxpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fastxpo.model.Partner;



@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
	
	 @Query("SELECT u.id FROM Partner u WHERE u.mobile = ?1")
		Long getPartnerByMobile(String mobile);

}
