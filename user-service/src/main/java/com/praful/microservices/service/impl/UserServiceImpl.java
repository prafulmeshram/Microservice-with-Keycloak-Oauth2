/**
 * 
 */
package com.praful.microservices.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.data.dto.User;
import com.praful.microservices.data.entity.UserEntity;
import com.praful.microservices.data.enums.Status;
import com.praful.microservices.keycloak.service.KeycloakService;
import com.praful.microservices.mapper.UserMapper;
import com.praful.microservices.payload.request.UserUpdateRequest;
import com.praful.microservices.repository.UserRepository;
import com.praful.microservices.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jack
 * 
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private KeycloakService keycloakService;
	@Autowired
	private UserRepository userRepository;

	private UserMapper userMapper = new UserMapper();

	@Override
	public User createUser(User user) {

		List<UserRepresentation> userRepresentations = this.keycloakService.readUserByEmail(user.getEmail());
		if (userRepresentations.size() > 0) {
			throw new RuntimeException("This email already registered as a user. Please check and retry.");
		}

		UserRepresentation userRepresentation = new UserRepresentation();
		userRepresentation.setEmail(user.getEmail());
		userRepresentation.setEmailVerified(false);
		userRepresentation.setEnabled(false);
		userRepresentation.setUsername(user.getEmail());

		CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
		credentialRepresentation.setValue(user.getPassword());
		credentialRepresentation.setTemporary(false);
		userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));

		Integer userCreationResponse = this.keycloakService.createUser(userRepresentation);

		if (userCreationResponse == 201) {
			log.info("User created under given username {}", user.getEmail());

			List<UserRepresentation> userRepresentations1 = this.keycloakService.readUserByEmail(user.getEmail());
			user.setAuthId(userRepresentations1.get(0).getId());
			user.setStatus(Status.PENDING);
			user.setIdentification(UUID.randomUUID().toString());
			UserEntity save = userRepository.save(userMapper.convertToEntity(user));
			return userMapper.convertToDto(save);
		}

		throw new RuntimeException("We couldn't find user under given identification. Please check and retry");

	}

	@Override
	public List<User> readUsers(Pageable pageable) {
		Page<UserEntity> allUsersInDb = userRepository.findAll(pageable);
		List<User> users = userMapper.convertToDtoList(allUsersInDb.getContent());
		users.forEach(user -> {
			UserRepresentation userRepresentation = this.keycloakService.readUser(user.getAuthId());
			user.setId(user.getId());
			user.setEmail(userRepresentation.getEmail());
			user.setIdentification(user.getIdentification());
		});
		return users;
	}

	@Override
	public User readUser(Long userId) {
		return userMapper.convertToDto(userRepository.findById(userId).orElseThrow(EntityNotFoundException::new));
	}

	@Override
	public User updateUser(Long id, UserUpdateRequest userUpdateRequest) {
		UserEntity userEntity = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);

		if (userUpdateRequest.getStatus() == Status.APPROVED) {
			UserRepresentation userRepresentation = this.keycloakService.readUser(userEntity.getAuthId());
			userRepresentation.setEnabled(true);
			userRepresentation.setEmailVerified(true);
			this.keycloakService.updateUser(userRepresentation);
		}

		userEntity.setStatus(userUpdateRequest.getStatus());
		return userMapper.convertToDto(userRepository.save(userEntity));
	}

}
