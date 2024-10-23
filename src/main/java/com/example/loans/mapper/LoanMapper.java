package com.example.loans.mapper;

import com.example.loans.dto.LoansDto;
import com.example.loans.entity.Loans;

public class LoanMapper {
	
	public static LoansDto mapToLoansDto(Loans loans,LoansDto loansDto) {
		loansDto.setMobileNumber(loans.getMobileNumber());
		loansDto.setLoanType(loans.getLoanType());
		loansDto.setAmountPaid(loans.getAmountPaid());
	   loansDto.setLoanNumber(loans.getLoanNumber());
	   loansDto.setTotalLoan(loans.getTotalLoan());
	   loansDto.setOutstandingAmount(loans.getOutstandingAmount());
	   
	   return loansDto;
	   
	}
	
	public static Loans mapToLoans(LoansDto loansDto,Loans loans) {
		loans.setMobileNumber(loansDto.getMobileNumber());
		loans.setLoanType(loansDto.getLoanType());
		loans.setAmountPaid(loansDto.getAmountPaid());
		loans.setLoanNumber(loansDto.getLoanNumber());
		loans.setTotalLoan(loansDto.getTotalLoan());
		loans.setOutstandingAmount(loansDto.getOutstandingAmount());
		
		return loans;
	}

}
