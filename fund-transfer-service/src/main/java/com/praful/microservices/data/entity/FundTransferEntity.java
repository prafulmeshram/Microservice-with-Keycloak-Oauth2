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
@Table(name = "fun_transfer")
public class FundTransferEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "transaction_reference")
	private String transactionReference;
	@Column(name = "from_account")
	private String fromAccount;
	@Column(name = "to_account")
	private String toAccount;
	@Column(name = "amount")
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private TransactionStatus status;
}
