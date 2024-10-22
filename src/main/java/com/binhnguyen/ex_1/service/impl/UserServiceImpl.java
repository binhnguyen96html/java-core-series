package com.binhnguyen.ex_1.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.binhnguyen.ex_1.model.dto.UserDTO;
import com.binhnguyen.ex_1.repository.UserRepository;
import com.binhnguyen.ex_1.repository.entity.UserEntity;
import com.binhnguyen.ex_1.repository.impl.UserRepositoryImpl;
import com.binhnguyen.ex_1.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserRepository userDao = new UserRepositoryImpl();

	@Override
	public List<UserDTO> findAll() {
		List<UserEntity> userEntities = userDao.findAll();
		
		List<UserDTO> results = new ArrayList<>();
		
		for(UserEntity item: userEntities) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserName(item.getUserName());
			
			results.add(userDTO);
		}
		
		return results;
	}

}
