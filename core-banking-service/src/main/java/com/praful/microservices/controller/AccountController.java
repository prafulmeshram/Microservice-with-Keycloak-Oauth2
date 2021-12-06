/**
 * 
 */
package com.praful.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praful.microservices.data.dto.BankAccount;
import com.praful.microservices.data.dto.UtilityAccount;
import com.praful.microservices.service.AccountService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jack
 *
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/v1/account")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("/bank-account/{account_number}")
	public ResponseEntity<BankAccount> getBankAccount(@PathVariable("account_number") String accountNumber) {
		log.info("Reading account by ID {}", accountNumber);
		return ResponseEntity.ok(accountService.readBankAccount(accountNumber));
	}

	@GetMapping("/util-account/{account_name}")
	public ResponseEntity<UtilityAccount> getUtilityAccount(@PathVariable("account_name") String providerName) {
		log.info("Reading utitlity account by ID {}", providerName);
		return ResponseEntity.ok(accountService.readUtilityAccount(providerName));
	}
}
