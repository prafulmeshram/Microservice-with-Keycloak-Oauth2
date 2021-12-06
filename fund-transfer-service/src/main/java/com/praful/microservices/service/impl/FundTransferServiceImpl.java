/**
 * 
 */
package com.praful.microservices.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.data.dto.FundTransfer;
import com.praful.microservices.data.entity.FundTransferEntity;
import com.praful.microservices.data.enums.TransactionStatus;
import com.praful.microservices.data.mapper.FundTransferMapper;
import com.praful.microservices.payload.request.FundTransferRequest;
import com.praful.microservices.payload.response.FundTransferResponse;
import com.praful.microservices.repository.FundTransferRepository;
import com.praful.microservices.service.FundTransferService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jack
 *
 */
@Slf4j
@Service
@Transactional
public class FundTransferServiceImpl implements FundTransferService  {

	@Autowired
	private FundTransferRepository fundTransferRepository;

	private FundTransferMapper mapper = new FundTransferMapper();

	@Override
	public FundTransferResponse fundTransfer(FundTransferRequest request) {
		log.info("Sending fund transfer request {}" + request.toString());

		FundTransferEntity entity = new FundTransferEntity();
		BeanUtils.copyProperties(request, entity);
		entity.setStatus(TransactionStatus.PENDING);
		@SuppressWarnings("unused")
		FundTransferEntity optFundTransfer = fundTransferRepository.save(entity);

		FundTransferResponse fundTransferResponse = new FundTransferResponse();
		fundTransferResponse.setTransactionId(UUID.randomUUID().toString());
		fundTransferResponse.setMessage("Success");

		return fundTransferResponse;

	}

	@Override
	public List<FundTransfer> readAllTransfers(Pageable pageable) {
		return mapper.convertToDtoList(fundTransferRepository.findAll(pageable).getContent());
	}
}
