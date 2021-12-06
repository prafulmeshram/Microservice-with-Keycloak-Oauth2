/**
 * 
 */
package com.praful.microservices.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.praful.microservices.data.dto.FundTransfer;
import com.praful.microservices.payload.request.FundTransferRequest;
import com.praful.microservices.payload.response.FundTransferResponse;

/**
 * @author jack
 *
 */
public interface FundTransferService {

	FundTransferResponse fundTransfer(FundTransferRequest request);

	List<FundTransfer> readAllTransfers(Pageable pageable);

}
