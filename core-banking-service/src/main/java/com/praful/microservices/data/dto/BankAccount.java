/**
 * 
 */
package com.praful.microservices.data.dto;

import java.math.BigDecimal;

import com.praful.microservices.data.enums.AccountStatus;
import com.praful.microservices.data.enums.AccountType;

import lombok.Data;

/**
 * @author jack
 *
 */
@Data
public class BankAccount {
	private Long id;
	private String number;
	private AccountType type;
	private AccountStatus status;
	private BigDecimal availableBalance;
	private BigDecimal actualBalance;
	private User user;
}
