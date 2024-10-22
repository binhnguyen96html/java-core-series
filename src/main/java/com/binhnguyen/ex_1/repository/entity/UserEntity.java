package com.binhnguyen.ex_1.repository.entity;

import com.binhnguyen.ex_1.annotation.Column;
import com.binhnguyen.ex_1.annotation.Entity;
import com.binhnguyen.ex_1.annotation.Table;

@Entity
@Table(name="user")
public class UserEntity {

	@Column(name="username")
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
