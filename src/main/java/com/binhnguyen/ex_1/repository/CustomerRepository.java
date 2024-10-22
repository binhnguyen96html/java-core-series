package com.binhnguyen.ex_1.repository;

import java.util.List;

import com.binhnguyen.ex_1.repository.entity.CustomerEntity;

public interface CustomerRepository extends JdbcRepository<CustomerEntity> {
	//List<CustomerEntity> findAll();
	//void insert (CustomerEntity  newCustomer);
}