/**
 * 
 */
package com.praful.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praful.microservices.data.dto.UtilityPayment;
import com.praful.microservices.payload.request.UtilityPaymentRequest;
import com.praful.microservices.payload.response.UtilityPaymentResponse;
import com.praful.microservices.service.UtilityPaymentService;

/**
 * @author jack
 *
 */

@RestController
@RequestMapping("/api/v1/utility-payment")
public class UtilityPaymentController {

	@Autowired
    private UtilityPaymentService utilityPaymentService;
    @GetMapping
    public ResponseEntity<List<UtilityPayment>> readPayments(Pageable pageable) {
        return ResponseEntity.ok(utilityPaymentService.readPayments(pageable));
    }
    @PostMapping
    public ResponseEntity<UtilityPaymentResponse> processPayment(@RequestBody UtilityPaymentRequest paymentRequest) {
        return ResponseEntity.ok(utilityPaymentService.utilPayment(paymentRequest));
    }

}
