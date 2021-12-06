/**
 * 
 */
package com.praful.microservices.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.praful.microservices.data.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jack
 *
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "banking_core_transaction")
public class TransactionEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -8223460470224013150L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "amount")
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_type")
	private TransactionType transactionType;

	@Column(name = "reference_number")
	private String referenceNumber;
	@Column(name = "transaction_id")
	private String transactionId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private BankAccountEntity account;

}
