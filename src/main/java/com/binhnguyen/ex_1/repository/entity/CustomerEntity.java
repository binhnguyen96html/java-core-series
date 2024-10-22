package com.binhnguyen.ex_1.repository.entity;

import com.binhnguyen.ex_1.annotation.Column;
import com.binhnguyen.ex_1.annotation.Entity;
import com.binhnguyen.ex_1.annotation.Table;

@Entity
@Table(name="customer")
public class CustomerEntity extends BaseEntity{
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
}
