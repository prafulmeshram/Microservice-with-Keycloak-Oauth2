/**
 * 
 */
package com.praful.microservices.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.praful.microservices.data.dto.User;

/**
 * @author jack
 *
 */
public interface UserService {

	User readUser(String identification);

	List<User> readUsers(Pageable pageable);

}
