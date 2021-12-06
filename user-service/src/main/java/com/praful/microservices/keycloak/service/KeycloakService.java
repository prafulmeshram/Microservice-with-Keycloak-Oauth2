/**
 * 
 */
package com.praful.microservices.keycloak.service;

import java.util.List;

import org.keycloak.representations.idm.UserRepresentation;

/**
 * @author jack
 *
 */
public interface KeycloakService {

	Integer createUser(UserRepresentation userRepresentation);

	void updateUser(UserRepresentation userRepresentation);

	List<UserRepresentation> readUserByEmail(String email);

	UserRepresentation readUser(String authId);

}
