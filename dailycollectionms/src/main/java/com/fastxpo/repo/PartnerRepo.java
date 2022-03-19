package com.fastxpo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fastxpo.bean.Partner;



public interface PartnerRepo extends JpaRepository<Partner, Long> {

    @Query("SELECT u.id FROM Partner u WHERE u.mobile = ?1")
	Long getPartnerByMobile(String mobile);
    
   /* @Query(value=”SELECT * FROM Users u WHERE u.EMAIL_VERIFICATION_STATUS = ?1  and u.platform=?2”,  nativeQuery = true)
    Collection<UserEntity> findAllUsersWithVerifiedEmailAddress(boolean emailVerificationStatus, String mobileDevicePlatform);
    
    */
    @Query(value="SELECT * FROM Partner u WHERE u.mobile = ?1  and u.password=?2",  nativeQuery = true)
  	Partner loginCheckByUserAndPassword(String mobile,String password);
    
	/*
	 * @Modifying
	 * 
	 * @Query("update Partner u set u.businessname = ?1, u.address = ?2 where u.mobile = ?3"
	 * ) Partner updatePartner(String businessname, String address, String mobile);
	 */
}
