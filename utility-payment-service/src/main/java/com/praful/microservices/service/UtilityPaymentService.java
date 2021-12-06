/**
 * 
 */
package com.praful.microservices.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.praful.microservices.data.dto.UtilityPayment;
import com.praful.microservices.payload.request.UtilityPaymentRequest;
import com.praful.microservices.payload.response.UtilityPaymentResponse;

/**
 * @author jack
 *
 */
public interface UtilityPaymentService {

	UtilityPaymentResponse utilPayment(UtilityPaymentRequest paymentRequest);

	List<UtilityPayment> readPayments(Pageable pageable);

}
