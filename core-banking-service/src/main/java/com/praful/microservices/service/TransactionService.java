/**
 * 
 */
package com.praful.microservices.service;

import java.math.BigDecimal;

import com.praful.microservices.data.dto.BankAccount;
import com.praful.microservices.payload.request.FundTransferRequest;
import com.praful.microservices.payload.request.UtilityPaymentRequest;
import com.praful.microservices.payload.response.FundTransferResponse;
import com.praful.microservices.payload.response.UtilityPaymentResponse;

/**
 * @author jack
 *
 */
public interface TransactionService {

	String internalFundTransfer(BankAccount fromBankAccount, BankAccount toBankAccount, BigDecimal amount);

	FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);

	UtilityPaymentResponse utilPayment(UtilityPaymentRequest utilityPaymentRequest);

}
