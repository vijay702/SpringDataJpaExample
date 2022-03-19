package com.fastxpo.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PAYMENT")
public class Payment extends Master {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	//@GenericGenerator(name = "native", strategy = "native")
	private Long paymentid;

	@ManyToOne()
	@JoinColumn(name = "dueid")
	private Due due;
	
	
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date paydate;
	private String paystatus;
	
	private String mode;
	private String detail;
	
	private BigDecimal paidamt;


	
	
	private Long mpaymentid;
	
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}



	public Long getMpaymentid() {
		return mpaymentid;
	}

	public void setMpaymentid(Long mpaymentid) {
		this.mpaymentid = mpaymentid;
	}

	public Long getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(Long paymentid) {
		this.paymentid = paymentid;
	}

	public Date getPaydate() {
		return paydate;
	}

	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}

	public String getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}

	public BigDecimal getPaidamt() {
		return paidamt;
	}

	public void setPaidamt(BigDecimal paidamt) {
		this.paidamt = paidamt;
	}

	public Due getDue() {
		return due;
	}

	public void setDue(Due due) {
		this.due = due;
	}

}
