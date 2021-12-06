/**
 * 
 */
package com.praful.microservices.data.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.praful.microservices.data.enums.TransactionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jack
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utility_payment")
public class UtilityPaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "provider_id")
	private Long providerId;
	@Column(name = "amount")
	private BigDecimal amount;
	@Column(name = "reference_number")
	private String referenceNumber;
	@Column(name = "account")
	private String account;
	@Column(name = "transaction_id")
	private String transactionId;
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private TransactionStatus status;
}
