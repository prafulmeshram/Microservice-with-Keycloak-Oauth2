/**
 * 
 */
package com.praful.microservices.data.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author jack
 *
 */
@Data
public class Transaction {
	private Long id;
	private BigDecimal amount;
	private BankAccount bankAccount;
	private String referenceNumber;
}
