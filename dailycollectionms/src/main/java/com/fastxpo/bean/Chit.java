package com.fastxpo.bean;

import java.math.BigDecimal;
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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//@Data

@Entity
@Table(name = "CHIT")
public class Chit extends Master {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long chitid;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	@JoinColumn(name = "chitid")
	private List<People> peoples = new ArrayList<People>();
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	@JoinColumn(name = "chitid")
	private List<Auction> auctions = new ArrayList<Auction>();
	
	
	
	
	
	@ManyToOne()
	@JoinColumn(name = "partnerid")
	private Partner partner;
	
	
	private String chitname;
	
	private Long mchitid;

//	private MultipartFile file;
	private String imgname;
	private String imgurl;
	private String imgpath;
	private String chitstatus;
	private String operation;
	private String chittype; // monthly,weekly,daily,yearly,quarterly,halfly
	private Integer members;// 10 members
	private Integer duration;//10 month
	private BigDecimal amount; // 10000Rs

	
	
	
	public List<Auction> getAuctions() {
		return auctions;
	}
	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}
	public Long getMchitid() {
		return mchitid;
	}
	public void setMchitid(Long mchitid) {
		this.mchitid = mchitid;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public Long getChitid() {
		return chitid;
	}
	public void setChitid(Long chitid) {
		this.chitid = chitid;
	}
	public String getChitname() {
		return chitname;
	}
	public void setChitname(String chitname) {
		this.chitname = chitname;
	}


	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getChitstatus() {
		return chitstatus;
	}
	public void setChitstatus(String chitstatus) {
		this.chitstatus = chitstatus;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getChittype() {
		return chittype;
	}
	public void setChittype(String chittype) {
		this.chittype = chittype;
	}
	public Integer getMembers() {
		return members;
	}
	public void setMembers(Integer members) {
		this.members = members;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public List<People> getPeoples() {
		return peoples;
	}
	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}

	
	
	

}
