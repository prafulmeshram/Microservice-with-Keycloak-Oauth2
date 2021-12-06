/**
 * 
 */
package com.praful.microservices.data.mapper;

import org.springframework.beans.BeanUtils;

import com.praful.microservices.data.dto.UtilityPayment;
import com.praful.microservices.data.entity.UtilityPaymentEntity;

/**
 * @author jack
 *
 */
public class UtilityPaymentMapper extends BaseMapper<UtilityPaymentEntity, UtilityPayment> {
	@Override
	public UtilityPaymentEntity convertToEntity(UtilityPayment dto, Object... args) {
		UtilityPaymentEntity entity = new UtilityPaymentEntity();
		if (dto != null) {
			BeanUtils.copyProperties(dto, entity);
		}
		return entity;
	}

	@Override
	public UtilityPayment convertToDto(UtilityPaymentEntity entity, Object... args) {
		UtilityPayment dto = new UtilityPayment();
		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);
		}
		return dto;
	}
}
