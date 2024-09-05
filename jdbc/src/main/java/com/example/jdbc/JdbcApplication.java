package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JdbcApplication {

	static final String DB_URL = "jdbc:mysql://localhost/sys";
	static final String USER = "root";
	static final String PASS = "Ilovejob123@";
	static final String QUERY = "SELECT * from building";

	public static void main(String[] args) {
		// SpringApplication.run(JdbcApplication.class, args);

		System.out.println("hello");

		String name = null;
		String street = null;
		String ward = null;
		Integer floorArea = 100;
		Integer numberOfBasement = 100;


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Step 1: Load driver 
			// Old (deprecated)
			// Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Create connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Step 3: initialize statmenet (Khoi tao doi tuong)
			stmt = conn.createStatement();

			// Step 4: Execute sql (thuc thi cau sql)
			rs = stmt.executeQuery(QUERY.toString());

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
