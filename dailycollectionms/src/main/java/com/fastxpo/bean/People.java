package com.fastxpo.bean;

import java.util.ArrayList;
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

@Entity
@Table(name = "PEOPLE")
public class People extends Master {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long peopleid;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "peopleid")
	private List<Payment> payments = new ArrayList<Payment>();


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chitid")
	private Chit chit;

	
	
	private Long mpeopleid;
	
	private String name;
	private String mobile;
	private String email;
	private String imgname;
	private String imgpath;
	private String imgurl;
	private String idproof;
	private String idattach;
	private String idattachpath;
	private String idattachurl;

	public Long getMpeopleid() {
		return mpeopleid;
	}

	public void setMpeopleid(Long mpeopleid) {
		this.mpeopleid = mpeopleid;
	}

	public Long getPeopleid() {
		return peopleid;
	}

	public void setPeopleid(Long peopleid) {
		this.peopleid = peopleid;
	}



	public Chit getChit() {
		return chit;
	}

	public void setChit(Chit chit) {
		this.chit = chit;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getIdproof() {
		return idproof;
	}

	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}

	public String getIdattach() {
		return idattach;
	}

	public void setIdattach(String idattach) {
		this.idattach = idattach;
	}

	public String getIdattachpath() {
		return idattachpath;
	}

	public void setIdattachpath(String idattachpath) {
		this.idattachpath = idattachpath;
	}

	public String getIdattachurl() {
		return idattachurl;
	}

	public void setIdattachurl(String idattachurl) {
		this.idattachurl = idattachurl;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}
