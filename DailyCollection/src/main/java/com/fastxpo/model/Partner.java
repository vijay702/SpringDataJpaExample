package com.fastxpo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class Partner {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native", strategy = "native")
	private Long partnerId;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "partnerId")
	private List<Borrower> borrower = new ArrayList<>();
	
	
	
    
	private String mobile;
	
	 
    private String partnerName;
	private String email;
	private String password;
	private String apistatus;

	private String apimsg;
	
	public Partner(List<Borrower> borrower, String apistatus, String apimsg) {
		super();
		this.borrower = borrower;
		this.apistatus = apistatus;
		this.apimsg = apimsg;
	}
	public List<Borrower> getBorrower() {
		return borrower;
	}
	public void setBorrower(List<Borrower> borrower) {
		this.borrower = borrower;
	}
	public String getApistatus() {
		return apistatus;
	}
	public void setApistatus(String apistatus) {
		this.apistatus = apistatus;
	}
	public String getApimsg() {
		return apimsg;
	}
	public void setApimsg(String apimsg) {
		this.apimsg = apimsg;
	}
	
	
	public Long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Partner(Long partnerId, @UniqueElements String mobile, String partnerName, String email, String password) {
		super();
		this.partnerId = partnerId;
		this.mobile = mobile;
		this.partnerName = partnerName;
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Partner() {
		
	}
	@Override
	public String toString() {
		return "Partner [partnerId=" + partnerId + ", mobile=" + mobile + ", partnerName=" + partnerName + ", email="
				+ email + ", password=" + password + "]";
	}

}
