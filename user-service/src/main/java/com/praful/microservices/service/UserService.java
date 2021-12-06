/**
 * 
 */
package com.praful.microservices.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.praful.microservices.data.dto.User;
import com.praful.microservices.payload.request.UserUpdateRequest;

/**
 * @author jack
 *
 */
public interface UserService {

	User updateUser(Long id, UserUpdateRequest userUpdateRequest);

	User readUser(Long userId);

	List<User> readUsers(Pageable pageable);

	User createUser(User user);

}
