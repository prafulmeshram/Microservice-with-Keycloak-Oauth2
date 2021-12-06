/**
 * 
 */
package com.praful.microservices.payload.response;

import lombok.Data;

/**
 * @author jack
 *
 */
@Data
public class FundTransferResponse {
	private String message;
    private String transactionId;
}
