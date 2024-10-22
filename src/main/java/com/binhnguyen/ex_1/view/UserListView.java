package com.binhnguyen.ex_1.view;

import com.binhnguyen.ex_1.controller.UserController;
import com.binhnguyen.ex_1.model.dto.UserDTO;

public class UserListView {

	public static void main(String[] args) {
		
		UserController userController = new UserController();
		
		for(UserDTO item: userController.findAll()) {
			System.out.println(item.getUserName());
		}
	}
}
