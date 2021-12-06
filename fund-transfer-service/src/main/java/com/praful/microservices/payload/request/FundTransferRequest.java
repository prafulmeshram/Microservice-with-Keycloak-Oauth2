/**
 * 
 */
package com.praful.microservices.payload.request;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author jack
 *
 */
@Data
public class FundTransferRequest {
	private String fromAccount;
	private String toAccount;
	private BigDecimal amount;
	private String authID;
}
