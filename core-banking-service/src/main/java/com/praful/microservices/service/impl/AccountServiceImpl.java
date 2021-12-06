/**
 * 
 */
package com.praful.microservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.data.dto.BankAccount;
import com.praful.microservices.data.dto.UtilityAccount;
import com.praful.microservices.data.entity.BankAccountEntity;
import com.praful.microservices.data.entity.UtilityAccountEntity;
import com.praful.microservices.data.mapper.BankAccountMapper;
import com.praful.microservices.data.mapper.UtilityAccountMapper;
import com.praful.microservices.repository.BankAccountRepository;
import com.praful.microservices.repository.UtilityAccountRepository;
import com.praful.microservices.service.AccountService;

/**
 * @author jack
 *
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private BankAccountMapper bankAccountMapper = new BankAccountMapper();
	private UtilityAccountMapper utilityAccountMapper = new UtilityAccountMapper();

	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private UtilityAccountRepository utilityAccountRepository;

	@Override
	public BankAccount readBankAccount(String accountNumber) {
		BankAccountEntity entity = bankAccountRepository.findByNumber(accountNumber).get();
		return bankAccountMapper.convertToDto(entity);
	}

	@Override
	public UtilityAccount readUtilityAccount(String provider) {
		UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findByProviderName(provider).get();
		return utilityAccountMapper.convertToDto(utilityAccountEntity);
	}

	@Override
	public UtilityAccount readUtilityAccount(Long id) {
		return utilityAccountMapper.convertToDto(utilityAccountRepository.findById(id).get());
	}

}
