/**
 * 
 */
package com.praful.microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.data.entity.UserEntity;

/**
 * @author jack
 *
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByIdentificationNumber(String identificationNumber);
}
