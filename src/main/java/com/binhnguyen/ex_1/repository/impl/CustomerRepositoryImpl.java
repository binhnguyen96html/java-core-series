package com.binhnguyen.ex_1.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.binhnguyen.ex_1.repository.CustomerRepository;
import com.binhnguyen.ex_1.repository.entity.CustomerEntity;
import com.binhnguyen.ex_1.utils.ConnectionUtils;

public class CustomerRepositoryImpl extends SimpleJdbcRepository<CustomerEntity> implements CustomerRepository {
	

}
