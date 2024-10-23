package com.example.loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.loans.constants.LoansConstants;
import com.example.loans.dto.ErrorResponseDto;
import com.example.loans.dto.LoansContactInfoDto;
import com.example.loans.dto.LoansDto;
import com.example.loans.dto.ResponseDto;
import com.example.loans.service.ILoansService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;


@RestController
@Tag(name = "CRUD  REST APIs  for Loans in EazyBank",
   description = "CRUD REST APIs on eazy bank to CREATE,UPDATE, FETCH AND DELETE loan details"
		)
@RequestMapping(path = "/api")
@Validated
public class LoansController {
	
	
	private final ILoansService iLoansService;
	
	
	public LoansController(ILoansService iLoansService) {
		this.iLoansService=iLoansService;
	}
	
	@Autowired
	private LoansContactInfoDto loansContactInfoDto;
	
	
	@Operation(
			summary = "Create Loan REST API"
			,description = "Rest Api to create new loan inside EazyBank"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "201",
					description = "HTTP Status CREATED"
					),
			@ApiResponse(
					responseCode = "500",
			         description = "HTTP Status Internal Server Error",
			 content = @Content(
					 schema = @Schema(implementation = ErrorResponseDto.class)
					 )
	)}
			
			)
	@PostMapping("/create")
	public ResponseEntity<ResponseDto>  createLoan(@Valid @RequestParam
			@Pattern(regexp = "(^$|[0-9]{10})",message = "MobileNumber must be 10 digits")
			String mobileNumber){
		
	iLoansService.createLoan(mobileNumber);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(LoansConstants.STATUS_201,LoansConstants.MESSAGE_201));
		
	}
	
	@Operation(
			summary = "FETCH Loan REST API"
			,description = "Rest Api to fetch new loan inside EazyBank"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "201",
					description = "HTTP Status CREATED"
					),
			@ApiResponse(
					responseCode = "500",
			         description = "HTTP Status Internal Server Error",
			 content = @Content(
					 schema = @Schema(implementation = ErrorResponseDto.class)
					 )
	)}
			
			)
	
	@GetMapping("/fetch")
	public ResponseEntity<LoansDto> fetchLoanDetails(@Valid @RequestParam
			@Pattern(regexp = "(^$|[0-9]{10})",message = "MobileNumber must be 10 digits")
	String mobileNumber
			){
		LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(loansDto);
	}
	
	@Operation(
			summary = "Create Loan REST API"
			,description = "Rest Api to create new loan inside EazyBank"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "201",
					description = "Http Status created"
					),
			@ApiResponse(
					responseCode = "417",
					description = "Expectation Failed"
					),
			@ApiResponse(
					responseCode = "500",
			         description = "HTTP Status Internal Server Error",
			 content = @Content(
					 schema = @Schema(implementation = ErrorResponseDto.class)
					 )
	)}
			
			)
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateLoanDetails(@Valid@RequestBody LoansDto loansDto){
		boolean isUpdated = iLoansService.updateLoan(loansDto);
		if(isUpdated) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(LoansConstants.MESSAGE_200,LoansConstants.MESSAGE_200));
		}else {
			return ResponseEntity
					.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(LoansConstants.STATUS_417,LoansConstants.MESSAGE_417_UPDATE));
					
		}
	}
		
		@Operation(
				summary = "delete Loan REST API"
				,description = "Rest Api to delete Loan details based on a mobileNumber"
				)
		@ApiResponses({
				@ApiResponse(
						responseCode = "201",
						description = "Http Status created"
						),
				@ApiResponse(
						responseCode = "417",
						description = "Expectation Failed"
						),
				@ApiResponse(
						responseCode = "500",
				         description = "HTTP Status Internal Server Error",
				 content = @Content(
						 schema = @Schema(implementation = ErrorResponseDto.class)
						 )
		)}
				
				)
		@DeleteMapping("/delete")
		public ResponseEntity<ResponseDto> deleteLoanDetails(@Valid @RequestParam
				@Pattern(regexp = "(^$|[0-9]{10})",message = "MobileNumber must be 10 digits")
                             String mobileNumber
				                          ){
			boolean isDeleted = iLoansService.deleteLoan(mobileNumber);
			if(isDeleted) {
				return ResponseEntity
						.status(HttpStatus.OK)
						.body(new ResponseDto(LoansConstants.MESSAGE_200,LoansConstants.MESSAGE_200));
			}else {
				return ResponseEntity
						.status(HttpStatus.EXPECTATION_FAILED)
						.body(new ResponseDto(LoansConstants.STATUS_417,LoansConstants.MESSAGE_417_DELETE));
						
			}
			
		}
		
		@Operation(
				summary = "Get build information"
				,description = "Get BUild information that is deployed into accounts microservices"
				)
		@ApiResponses({
				@ApiResponse(
						responseCode = "201",
						description = "Http Status created"
						),
				@ApiResponse(
						responseCode = "417",
						description = "Expectation Failed"
						),
				@ApiResponse(
						responseCode = "500",
				         description = "HTTP Status Internal Server Error",
				 content = @Content(
						 schema = @Schema(implementation = ErrorResponseDto.class)
						 )
		)}
				
				)
		@GetMapping("/contact-info")
		public ResponseEntity<LoansContactInfoDto> getContactInfo(){
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(loansContactInfoDto);
		}
		
	}
	


