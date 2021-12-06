/**
 * 
 */
package com.praful.microservices.data.dto;

import java.util.List;

import lombok.Data;

/**
 * @author jack
 *
 */
@Data
public class User {

	private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String identificationNumber;
    private List<BankAccount> bankAccounts;
	
}
