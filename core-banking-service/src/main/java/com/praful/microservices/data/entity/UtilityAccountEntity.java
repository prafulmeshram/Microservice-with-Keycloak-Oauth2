/**
 * 
 */
package com.praful.microservices.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "banking_core_utility_account")
public class UtilityAccountEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -8720950821553006822L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private String number;
	@Column(name = "provider_name")
	private String providerName;

}
