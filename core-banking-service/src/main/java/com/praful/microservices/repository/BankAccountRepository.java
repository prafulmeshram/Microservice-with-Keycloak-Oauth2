/**
 * 
 */
package com.praful.microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.data.entity.BankAccountEntity;

/**
 * @author jack
 *
 */

@Repository
@Transactional
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {

	Optional<BankAccountEntity> findByNumber(String accountNumber);
	
}
