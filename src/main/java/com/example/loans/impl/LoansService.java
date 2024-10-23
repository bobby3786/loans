package com.example.loans.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loans.constants.LoansConstants;
import com.example.loans.dto.LoansDto;
import com.example.loans.entity.Loans;
import com.example.loans.exception.LoanAlreadyExistsException;
import com.example.loans.exception.ResourceNotFoundException;
import com.example.loans.mapper.LoanMapper;
import com.example.loans.repository.LoansRepository;
import com.example.loans.service.ILoansService;

@Service
public class LoansService implements ILoansService{
	
	@Autowired
	private LoansRepository loansRepository;
	


	@Override
	public void createLoan(String mobileNumber) {
	Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
		if(optionalLoans.isPresent()) {
			throw new LoanAlreadyExistsException("Loan Already registered with given mobileNumber"+mobileNumber);
		}
		loansRepository.save(createNewLoan(mobileNumber));
		
	}
	
	private Loans createNewLoan(String mobileNumber) {
		Loans newLoan = new Loans();
		long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
		newLoan.setLoanNumber(Long.toString(randomLoanNumber));
		newLoan.setMobileNumber(mobileNumber);
		newLoan.setLoanType(LoansConstants.HOME_LOAN);
		newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
		newLoan.setAmountPaid(0);
		newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
		
		return newLoan;
	}

	@Override
	public LoansDto fetchLoan(String mobileNumber) {
		Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()-> new ResourceNotFoundException("Loan","mobileNumber",mobileNumber)
				);
		return LoanMapper.mapToLoansDto(loans, new LoansDto());
	}

	@Override
	public boolean updateLoan(LoansDto loansDto) {
		Loans loans= loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
				()-> new ResourceNotFoundException("Loan","LoanNumber",loansDto.getLoanNumber()));
		LoanMapper.mapToLoans(loansDto, loans);
		loansRepository.save(loans);
		return true;
	}

	@Override
	public boolean deleteLoan(String mobileNumber) {
		Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()-> new ResourceNotFoundException("Loan","mobileNumber",mobileNumber)
				);
		loansRepository.deleteById(loans.getLoanId());
		return true;
	}
}