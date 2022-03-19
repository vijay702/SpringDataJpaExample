package com.fastxpo.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PARTNER")
public class Partner extends Master {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long partnerid;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "partnerid")
	private List<Chit> chits = new ArrayList<Chit>();
	
	
	
	private Long mpartnerid;
	private String name;
	private String businessname;

	// @UniqueConstraint(columnNames={"mobile"})
	private String mobile;
	private String address;
	private String email;
	private String password;
	private String pin;

	private BigDecimal charge;

	private String apistatus;

	private String apimsg;

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

	public Long getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(Long partnerid) {
		this.partnerid = partnerid;
	}

	public Long getMpartnerid() {
		return mpartnerid;
	}

	public void setMpartnerid(Long mpartnerid) {
		this.mpartnerid = mpartnerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public BigDecimal getCharge() {
		return charge;
	}

	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

}
