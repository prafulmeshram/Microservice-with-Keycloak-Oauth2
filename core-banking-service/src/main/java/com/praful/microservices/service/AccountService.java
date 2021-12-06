/**
 * 
 */
package com.praful.microservices.service;

import com.praful.microservices.data.dto.BankAccount;
import com.praful.microservices.data.dto.UtilityAccount;

/**
 * @author jack
 *
 */
public interface AccountService {

	BankAccount readBankAccount(String accountNumber);

	UtilityAccount readUtilityAccount(String provider);

	UtilityAccount readUtilityAccount(Long id);

}
