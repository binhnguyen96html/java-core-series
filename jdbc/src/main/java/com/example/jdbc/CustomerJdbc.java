package com.example.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jdbc.constant.SystemConstant;
import com.example.jdbc.utils.ConnectionUtils;


@SpringBootApplication
public class CustomerJdbc {


	public static void main(String[] args) {
		// SpringApplication.run(JdbcApplication.class, args);


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Cong chuoi - StringBuilder
			StringBuilder query = new StringBuilder("SELECT * FROM customer " + SystemConstant.ONE_EQUAL_ONE);


			System.out.println("query: " + query);

			// Step 1: Load driver 
			// Old (deprecated)
			// Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Create connection
			// conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn = ConnectionUtils.getConnection();

			// Step 3: initialize statmenet (Khoi tao doi tuong)
			stmt = conn.createStatement();

			// Step 4: Execute sql (thuc thi cau sql)
			rs = stmt.executeQuery(query.toString());

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}finally{
			//Always run this after run all above
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		
	}

}
