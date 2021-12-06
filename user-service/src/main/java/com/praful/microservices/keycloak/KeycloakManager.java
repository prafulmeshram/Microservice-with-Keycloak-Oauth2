/**
 * 
 */
package com.praful.microservices.keycloak;

import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jack
 *
 */
@Component
public class KeycloakManager {

	@Autowired
	private KeycloakProperties keycloakProperties;

	public RealmResource getKeyCloakInstanceWithRealm() {
		return keycloakProperties.getInstance().realm(keycloakProperties.getRealm());
	}

}
