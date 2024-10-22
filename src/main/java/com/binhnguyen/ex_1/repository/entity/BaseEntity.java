package com.binhnguyen.ex_1.repository.entity;

import com.binhnguyen.ex_1.annotation.Column;

public class BaseEntity {

	@Column(name="id")
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
