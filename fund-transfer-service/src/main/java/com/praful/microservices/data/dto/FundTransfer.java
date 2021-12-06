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
public class FundTransfer {
	private Long id;
	private String transactionReference;
	private String status;
	private String fromAccount;
	private String toAccount;
	private BigDecimal amount;
}
