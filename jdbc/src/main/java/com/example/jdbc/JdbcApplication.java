package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jdbc.constant.SystemConstant;

import ch.qos.logback.core.util.StringUtil;


@SpringBootApplication
public class JdbcApplication {

	static final String DB_URL = "jdbc:mysql://localhost/sys";
	static final String USER = "root";
	static final String PASS = "Ilovejob123@";

	public static void main(String[] args) {
		// SpringApplication.run(JdbcApplication.class, args);

		// String name = null;
		// String street = null;
		// String district = null;
		// String ward = null;
		// String floorArea = null;
		// Integer numberOfBasement = 100;

		String name = "name 1";
		String street = "street 1";
		String district = "district 1";
		String ward = "ward 1";
		String floorArea = "floorarea 1";
		Integer numberOfBasement = 50;


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Cong chuoi - StringBuilder
			StringBuilder query = new StringBuilder("SELECT * FROM building " + SystemConstant.ONE_EQUAL_ONE);

			if(!StringUtil.isNullOrEmpty(name)){ 
				query.append(" and name like '%" + name + "%'");
			}
			if(!StringUtil.isNullOrEmpty(street)){ 
				query.append(" and street like '%" + street + "%'");
			}
			if(!StringUtil.isNullOrEmpty(district)){ 
				query.append(" and district like '%" + district + "%'");
			}
			if(!StringUtil.isNullOrEmpty(ward)){ 
				query.append(" and ward like '%" + ward + "%'");
			}
			if(!StringUtil.isNullOrEmpty(floorArea)){ 
				query.append(" and floorarea like '%" + floorArea + "%'");
			}
			if(numberOfBasement != null){
				query.append(" and basement like '%" + numberOfBasement + "%'");
			}

			System.out.println("query: " + query);

			// Step 1: Load driver 
			// Old (deprecated)
			// Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Create connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Step 3: initialize statmenet (Khoi tao doi tuong)
			stmt = conn.createStatement();

			// Step 4: Execute sql (thuc thi cau sql)
			rs = stmt.executeQuery(query.toString());

			// metadata
			ResultSetMetaData rsmd = rs.getMetaData();

			while(rs.next()){
				System.out.println("id: " + rs.getLong("id") + " , Type: " + rsmd.getColumnType(1));
				System.out.println("name: " + rs.getString("name"));
				System.out.println("street: " + rs.getString("street"));
				System.out.println("district: " + rs.getString("district"));
				System.out.println("ward: " + rs.getString("ward"));
				System.out.println("floorarea: " + rs.getString("floorarea"));
			}


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
