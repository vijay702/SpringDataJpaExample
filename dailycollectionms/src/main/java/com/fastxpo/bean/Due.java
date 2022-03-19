package com.fastxpo.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
// instalments
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "DUE")
//installment
public class Due extends Master {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long dueid;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "dueid")
	private List<Payment> payments = new ArrayList<Payment>();
	
	
	@ManyToOne()
	@JoinColumn(name = "peopleid")
	private People people;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "auctionid")
	private Auction auction;
	
	
	
	private Long mdueid;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date duedate;
	private BigDecimal dueamt;
	private String duestatus;
	
	
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	public Long getMdueid() {
		return mdueid;
	}
	public void setMdueid(Long mdueid) {
		this.mdueid = mdueid;
	}
	public Long getDueid() {
		return dueid;
	}
	public void setDueid(Long dueid) {
		this.dueid = dueid;
	}

	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public BigDecimal getDueamt() {
		return dueamt;
	}
	public void setDueamt(BigDecimal dueamt) {
		this.dueamt = dueamt;
	}
	public String getDuestatus() {
		return duestatus;
	}
	public void setDuestatus(String duestatus) {
		this.duestatus = duestatus;
	}
	
	
	
    	

}
