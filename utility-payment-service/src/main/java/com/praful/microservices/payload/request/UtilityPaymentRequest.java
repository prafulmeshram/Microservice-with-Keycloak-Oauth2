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
public class UtilityPaymentRequest {
	private Long providerId;
	private BigDecimal amount;
	private String referenceNumber;
	private String account;
}
