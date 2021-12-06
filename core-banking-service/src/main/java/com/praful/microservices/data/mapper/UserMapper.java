/**
 * 
 */
package com.praful.microservices.data.mapper;

import org.springframework.beans.BeanUtils;

import com.praful.microservices.data.dto.User;
import com.praful.microservices.data.entity.UserEntity;

/**
 * @author jack
 *
 */
public class UserMapper extends BaseMapper<UserEntity, User> {
	
	 private BankAccountMapper bankAccountMapper = new BankAccountMapper();

	    @Override
	    public UserEntity convertToEntity(User dto, Object... args) {
	        UserEntity entity = new UserEntity();
	        if (dto != null) {
	            BeanUtils.copyProperties(dto, entity, "accounts");
	            entity.setAccounts(bankAccountMapper.convertToEntityList(dto.getBankAccounts()));
	        }
	        return entity;
	    }

	    @Override
	    public User convertToDto(UserEntity entity, Object... args) {
	        User dto = new User();
	        if (entity != null) {
	            BeanUtils.copyProperties(entity, dto, "accounts");
	            dto.setBankAccounts(bankAccountMapper.convertToDtoList(entity.getAccounts()));
	        }
	        return dto;
	    }
	
}
