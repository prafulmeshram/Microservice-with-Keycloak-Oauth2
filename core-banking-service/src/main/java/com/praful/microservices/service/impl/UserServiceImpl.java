/**
 * 
 */
package com.praful.microservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.praful.microservices.data.dto.User;
import com.praful.microservices.data.entity.UserEntity;
import com.praful.microservices.data.mapper.UserMapper;
import com.praful.microservices.repository.UserRepository;
import com.praful.microservices.service.UserService;

/**
 * @author jack
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserMapper userMapper = new UserMapper();

	@Autowired
	private UserRepository userRepository;

	@Override
	public User readUser(String identification) {
		UserEntity userEntity = userRepository.findByIdentificationNumber(identification).get();
		return userMapper.convertToDto(userEntity);
	}

	@Override
	public List<User> readUsers(Pageable pageable) {
		return userMapper.convertToDtoList(userRepository.findAll(pageable).getContent());
	}

}
