/**
 * 
 */
package com.praful.microservices.keycloak.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.keycloak.KeycloakManager;
import com.praful.microservices.keycloak.service.KeycloakService;

/**
 * @author jack
 *
 */
@Service
@Transactional
public class KeycloakServiceImpl implements KeycloakService {
	@Autowired
	private KeycloakManager keyCloakManager;

	@Override
	public Integer createUser(UserRepresentation userRepresentation) {
		Response response = keyCloakManager.getKeyCloakInstanceWithRealm().users().create(userRepresentation);
		return response.getStatus();
	}

	@Override
	public void updateUser(UserRepresentation userRepresentation) {
		keyCloakManager.getKeyCloakInstanceWithRealm().users().get(userRepresentation.getId())
				.update(userRepresentation);
	}

	@Override
	public List<UserRepresentation> readUserByEmail(String email) {
		return keyCloakManager.getKeyCloakInstanceWithRealm().users().search(email);
	}

	@Override
	public UserRepresentation readUser(String authId) {
		try {
			UserResource userResource = keyCloakManager.getKeyCloakInstanceWithRealm().users().get(authId);
			return userResource.toRepresentation();
		} catch (Exception e) {
			throw new RuntimeException("User not found under given ID");
		}
	}
}
