/**
 * 
 */
package com.praful.microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.data.entity.UtilityAccountEntity;

/**
 * @author jack
 *
 */
@Repository
@Transactional
public interface UtilityAccountRepository extends JpaRepository<UtilityAccountEntity, Long> {
	Optional<UtilityAccountEntity> findByProviderName(String provider);
}
