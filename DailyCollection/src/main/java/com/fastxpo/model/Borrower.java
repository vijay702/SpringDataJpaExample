package com.fastxpo.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Borrower {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native", strategy = "native")
	private Long borrowerId;
	
	@ManyToOne
	@JoinColumn(name ="partnerId")
	private Partner partner;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
	@JoinColumn(name = "borrowerId")
	private List<Due> due = new ArrayList<>();
	
	private String name;
	
	
	public List<Due> getDue() {
		return due;
	}
	public void setDue(List<Due> due) {
		this.due = due;
	}

	private String mobile;
    private String address;
    
    
    
	
	public Borrower(Partner partner) {
		super();
		this.partner = partner;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}


    
    
	public Borrower(Long borrowerId, String name, @UniqueElements String mobile, String address) {
		super();
		this.borrowerId = borrowerId;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}
	public Long getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(Long borrowerId) {
		this.borrowerId = borrowerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Borrower [borrowerId=" + borrowerId + ", name=" + name + ", mobile=" + mobile + ", address=" + address
				+ "]";
	}

     public Borrower() {
    	 
     }

    
	

}
