/**
 * 
 */
package com.praful.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.data.entity.FundTransferEntity;

/**
 * @author jack
 *
 */
@Repository
@Transactional
public interface FundTransferRepository extends JpaRepository<FundTransferEntity, Long> {

}
