/**
 * 
 */
package com.praful.microservices.payload.request;

import com.praful.microservices.data.enums.Status;

import lombok.Data;

/**
 * @author jack
 *
 */
@Data
public class UserUpdateRequest {

	private Status status;
	
}
