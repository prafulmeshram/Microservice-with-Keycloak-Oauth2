/**
 * 
 */
package com.praful.microservices.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.data.dto.UtilityPayment;
import com.praful.microservices.data.entity.UtilityPaymentEntity;
import com.praful.microservices.data.enums.TransactionStatus;
import com.praful.microservices.data.mapper.UtilityPaymentMapper;
import com.praful.microservices.payload.request.UtilityPaymentRequest;
import com.praful.microservices.payload.response.UtilityPaymentResponse;
import com.praful.microservices.repository.UtilityPaymentRepository;
import com.praful.microservices.service.UtilityPaymentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jack
 *
 */
@Slf4j
@Service
@Transactional
public class UtilityPaymentServiceImpl implements UtilityPaymentService {

	@Autowired
	private UtilityPaymentRepository utilityPaymentRepository;
	private UtilityPaymentMapper utilityPaymentMapper = new UtilityPaymentMapper();

	@Override
	public UtilityPaymentResponse utilPayment(UtilityPaymentRequest paymentRequest) {
		log.info("Utility payment processing {}", paymentRequest.toString());
		UtilityPaymentEntity entity = new UtilityPaymentEntity();
		BeanUtils.copyProperties(paymentRequest, entity);
		entity.setStatus(TransactionStatus.PROCESSING);
		UtilityPaymentEntity optUtilPayment = utilityPaymentRepository.save(entity);
		String transactionId = UUID.randomUUID().toString();
		optUtilPayment.setStatus(TransactionStatus.SUCCESS);
		optUtilPayment.setTransactionId(transactionId);
		utilityPaymentRepository.save(optUtilPayment);
		return UtilityPaymentResponse.builder().message("Utility Payment Successfully Processed")
				.transactionId(transactionId).build();
	}

	@Override
	public List<UtilityPayment> readPayments(Pageable pageable) {
		Page<UtilityPaymentEntity> allUtilPayments = utilityPaymentRepository.findAll(pageable);
		return utilityPaymentMapper.convertToDtoList(allUtilPayments.getContent());
	}
}
