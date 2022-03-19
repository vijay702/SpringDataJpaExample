package com.fastxpo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native", strategy = "native")
	private Long paymentId;
	
	@ManyToOne
	@JoinColumn(name ="dueId")
	private Due due;
	
	
	private String paidAmount;
	private String payMode;
	
	
	
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Due getDue() {
		return due;
	}
	public void setDue(Due due) {
		this.due = due;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", due=" + due + ", paidAmount=" + paidAmount + ", payMode="
				+ payMode + "]";
	}
	

	
	
	
	
	

}
