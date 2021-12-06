/**
 * 
 */
package com.praful.microservices.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.praful.microservices.data.enums.AccountStatus;
import com.praful.microservices.data.enums.AccountType;

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
@Table(name = "banking_core_account")
public class BankAccountEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2390858625153105765L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private String number;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private AccountType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private AccountStatus status;

	@Column(name = "available_balance")
	private BigDecimal availableBalance;

	@Column(name = "actual_balance")
	private BigDecimal actualBalance;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

}
