/**
 * 
 */
package com.praful.microservices.data.dto;

import com.praful.microservices.data.enums.Status;

import lombok.Data;

/**
 * @author jack
 *
 */
@Data
public class User {
	private Long id;

	private String email;

	private String identification;

	private String password;

	private String authId;

	private Status status;
}
