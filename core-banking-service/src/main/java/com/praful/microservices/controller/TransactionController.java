/**
 * 
 */
package com.praful.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praful.microservices.payload.request.FundTransferRequest;
import com.praful.microservices.payload.request.UtilityPaymentRequest;
import com.praful.microservices.payload.response.FundTransferResponse;
import com.praful.microservices.payload.response.UtilityPaymentResponse;
import com.praful.microservices.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jack
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/fund-transfer")
	public ResponseEntity<FundTransferResponse> fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {

		log.info("Fund transfer initiated in core bank from {}", fundTransferRequest.toString());
		return ResponseEntity.ok(transactionService.fundTransfer(fundTransferRequest));

	}

	@PostMapping("/util-payment")
	public ResponseEntity<UtilityPaymentResponse> utilPayment(@RequestBody UtilityPaymentRequest utilityPaymentRequest) {

		log.info("Utility Payment initiated in core bank from {}", utilityPaymentRequest.toString());
		return ResponseEntity.ok(transactionService.utilPayment(utilityPaymentRequest));

	}

}
