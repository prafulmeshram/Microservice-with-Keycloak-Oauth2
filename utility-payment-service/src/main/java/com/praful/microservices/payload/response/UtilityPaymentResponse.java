/**
 * 
 */
package com.praful.microservices.payload.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author jack
 *
 */
@Data
@Builder
public class UtilityPaymentResponse {
	private String message;
	private String transactionId;	
}
