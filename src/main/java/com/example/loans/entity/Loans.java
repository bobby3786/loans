package com.example.loans.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loans extends BaseEntity{
	
	
	@Id
	@Column(name = "loan_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanId;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "loan_number")
	private String loanNumber;
	
	@Column(name = "loan_type")
	private String loanType;
	
	@Column(name = "total_loan")
	private int totalLoan;
	
	@Column(name = "amount_paid")
	private int amountPaid;
	
	@Column(name = "outstanding_amount")
	private int outstandingAmount;

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(int totalLoan) {
		this.totalLoan = totalLoan;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(int outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Loans(Long loanId, String mobileNumber, String loanNumber, String loanType, int totalLoan, int amountPaid,
			int outstandingAmount) {
		super();
		this.loanId = loanId;
		this.mobileNumber = mobileNumber;
		this.loanNumber = loanNumber;
		this.loanType = loanType;
		this.totalLoan = totalLoan;
		this.amountPaid = amountPaid;
		this.outstandingAmount = outstandingAmount;
	}

	public Loans() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Loans [loanId=" + loanId + ", mobileNumber=" + mobileNumber + ", loanNumber=" + loanNumber
				+ ", loanType=" + loanType + ", totalLoan=" + totalLoan + ", amountPaid=" + amountPaid
				+ ", outstandingAmount=" + outstandingAmount + "]";
	}
	
	

}
