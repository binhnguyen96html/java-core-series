package com.binhnguyen.ex_1.service;

import java.util.List;

import com.binhnguyen.ex_1.model.dto.UserDTO;

public interface UserService {
	List<UserDTO> findAll();
}
