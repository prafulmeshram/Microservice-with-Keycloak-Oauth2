/**
 * 
 */
package com.praful.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praful.microservices.data.dto.FundTransfer;
import com.praful.microservices.payload.request.FundTransferRequest;
import com.praful.microservices.payload.response.FundTransferResponse;
import com.praful.microservices.service.FundTransferService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jack
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/transfer")
public class FundTransferController {
	@Autowired
	private FundTransferService fundTransferService;

	@PostMapping
	public ResponseEntity<FundTransferResponse> sendFundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
		log.info("Got fund transfer request from API {}", fundTransferRequest.toString());
		return ResponseEntity.ok(fundTransferService.fundTransfer(fundTransferRequest));
	}

	@GetMapping
	public ResponseEntity<List<FundTransfer>> readFundTransfers(Pageable pageable) {
		log.info("Reading fund transfers from core");
		return ResponseEntity.ok(fundTransferService.readAllTransfers(pageable));
	}
}
