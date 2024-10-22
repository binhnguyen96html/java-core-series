package com.binhnguyen.ex_1.controller;

import java.util.List;

import com.binhnguyen.ex_1.model.dto.UserDTO;
import com.binhnguyen.ex_1.service.UserService;
import com.binhnguyen.ex_1.service.impl.UserServiceImpl;

public class UserController {
	
	private UserService userService = new UserServiceImpl();

	public List<UserDTO> findAll(){
		
		return userService.findAll();
	}
}
