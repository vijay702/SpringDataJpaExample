package com.fastxpo.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "AUCTION")
public class Auction extends Master {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chitid")
	private Chit chit;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long auctionid;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date auctiondate;
	private BigDecimal bidamt;
	private BigDecimal chitamt;
	private BigDecimal charge;
	private BigDecimal finalamt;
	private BigDecimal membercontributeamt;
	private BigDecimal memberamt;
	private BigDecimal memberinterestamt;

	private String auctionstatus;

	private Long mauctionid;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
	@JoinColumn(name = "auctionid")
	private List<Due> dues = new ArrayList<Due>();

	@ManyToOne()
	@JoinColumn(name = "peopleid")
	private People people;

	public String getAuctionstatus() {
		return auctionstatus;
	}

	public void setAuctionstatus(String auctionstatus) {
		this.auctionstatus = auctionstatus;
	}

	public Long getMauctionid() {
		return mauctionid;
	}

	public void setMauctionid(Long mauctionid) {
		this.mauctionid = mauctionid;
	}

	public List<Due> getDues() {
		return dues;
	}

	public void setDues(List<Due> dues) {
		this.dues = dues;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Chit getChit() {
		return chit;
	}

	public void setChit(Chit chit) {
		this.chit = chit;
	}

	public Long getAuctionid() {
		return auctionid;
	}

	public void setAuctionid(Long auctionid) {
		this.auctionid = auctionid;
	}

	public Date getAuctiondate() {
		return auctiondate;
	}

	public void setAuctiondate(Date auctiondate) {
		this.auctiondate = auctiondate;
	}

	public BigDecimal getBidamt() {
		return bidamt;
	}

	public void setBidamt(BigDecimal bidamt) {
		this.bidamt = bidamt;
	}

	public BigDecimal getChitamt() {
		return chitamt;
	}

	public void setChitamt(BigDecimal chitamt) {
		this.chitamt = chitamt;
	}

	public BigDecimal getCharge() {
		return charge;
	}

	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

	public BigDecimal getFinalamt() {
		return finalamt;
	}

	public void setFinalamt(BigDecimal finalamt) {
		this.finalamt = finalamt;
	}

	public BigDecimal getMembercontributeamt() {
		return membercontributeamt;
	}

	public void setMembercontributeamt(BigDecimal membercontributeamt) {
		this.membercontributeamt = membercontributeamt;
	}

	public BigDecimal getMemberamt() {
		return memberamt;
	}

	public void setMemberamt(BigDecimal memberamt) {
		this.memberamt = memberamt;
	}

	public BigDecimal getMemberinterestamt() {
		return memberinterestamt;
	}

	public void setMemberinterestamt(BigDecimal memberinterestamt) {
		this.memberinterestamt = memberinterestamt;
	}

}
