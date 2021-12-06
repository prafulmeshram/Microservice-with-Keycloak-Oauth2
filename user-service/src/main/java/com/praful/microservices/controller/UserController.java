/**
 * 
 */
package com.praful.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praful.microservices.data.dto.User;
import com.praful.microservices.payload.request.UserUpdateRequest;
import com.praful.microservices.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jack
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/bank-user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/register")
	public ResponseEntity<User> createUser(@RequestBody User request) {
		log.info("Creating user with {}", request.toString());
		return ResponseEntity.ok(userService.createUser(request));
	}

	@PatchMapping(value = "/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
			@RequestBody UserUpdateRequest userUpdateRequest) {
		log.info("Updating user with {}", userUpdateRequest.toString());
		return ResponseEntity.ok(userService.updateUser(userId, userUpdateRequest));
	}

	@GetMapping
	public ResponseEntity<List<User>> readUsers(Pageable pageable) {
		log.info("Reading all users from API");
		return ResponseEntity.ok(userService.readUsers(pageable));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> readUser(@PathVariable("id") Long id) {
		log.info("Reading user by id {}", id);
		return ResponseEntity.ok(userService.readUser(id));
	}

}
