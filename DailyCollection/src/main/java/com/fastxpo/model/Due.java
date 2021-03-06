package com.fastxpo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Due {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native", strategy = "native")
	private Long dueId;
	
	@ManyToOne
	@JoinColumn(name ="borrowerId")
	private Borrower borrower;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true )
	@JoinColumn(name = "dueId")
	private List<Payment> payment = new ArrayList<>();
	
	
	
	public List<Payment> getPayment() {
		return payment;
	}
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}
	private BigDecimal amount;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date  dueDate;
	private String duestatus;
	
	
	
	public Long getDueId() {
		return dueId;
	}
	public void setDueId(Long dueId) {
		this.dueId = dueId;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getDuestatus() {
		return duestatus;
	}
	public void setDuestatus(String duestatus) {
		this.duestatus = duestatus;
	}
	public Due(Long dueId, Borrower borrower, BigDecimal amount, Date dueDate, String duestatus) {
		super();
		this.dueId = dueId;
		this.borrower = borrower;
		this.amount = amount;
		this.dueDate = dueDate;
		this.duestatus = duestatus;
	}
	@Override
	public String toString() {
		return "Due [dueId=" + dueId + ", borrower=" + borrower + ", amount=" + amount + ", dueDate=" + dueDate
				+ ", duestatus=" + duestatus + "]";
	}
	public Due() {
		
	}


	

}
