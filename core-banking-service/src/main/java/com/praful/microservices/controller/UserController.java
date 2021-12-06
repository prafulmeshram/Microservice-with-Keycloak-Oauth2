/**
 * 
 */
package com.praful.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praful.microservices.data.dto.User;
import com.praful.microservices.service.UserService;

/**
 * @author jack
 *
 */

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/{identification}")
	public ResponseEntity<User> readUser(@PathVariable("identification") String identification) {
		return ResponseEntity.ok(userService.readUser(identification));
	}

	@GetMapping
	public ResponseEntity<List<User>> readUser(Pageable pageable) {
		return ResponseEntity.ok(userService.readUsers(pageable));
	}

}
