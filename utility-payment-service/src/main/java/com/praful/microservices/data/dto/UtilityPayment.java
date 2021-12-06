/**
 * 
 */
package com.praful.microservices.data.dto;

import java.math.BigDecimal;

import com.praful.microservices.data.enums.TransactionStatus;

import lombok.Data;

/**
 * @author jack
 *
 */
@Data
public class UtilityPayment {
    private Long providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;
    private TransactionStatus status;
}
