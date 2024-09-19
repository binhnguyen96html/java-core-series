package com.binhnguyen.ex_1.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.binhnguyen.ex_1.constant.SystemConstant;
import com.binhnguyen.ex_1.dao.BuildingDao;
import com.binhnguyen.ex_1.dao.anhyeuem.BuildingAnhyeuem;
import com.binhnguyen.ex_1.dao.anhyeuem.RentAreaAnhyeuem;
import com.binhnguyen.ex_1.utils.ConnectionUtils;
import com.mysql.cj.util.StringUtils;

public class BuildingDaoImpl implements BuildingDao {

	@Override
	public List<BuildingAnhyeuem> findBuilding(String name, String street, String district, String ward,
			Integer floorArea) {

		// BuildingAnhyeuem[] results = new BuildingAnhyeuem[3];
		List<BuildingAnhyeuem> results = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		
		try {
			// Cong chuoi - StringBuilder
			StringBuilder query = new StringBuilder("SELECT * FROM building " + SystemConstant.ONE_EQUAL_ONE);

			if (!StringUtils.isNullOrEmpty(name)) {
				query.append(" and name like '%" + name + "%'");
			}
			if (!StringUtils.isNullOrEmpty(street)) {
				query.append(" and street like '%" + street + "%'");
			}
			if (!StringUtils.isNullOrEmpty(district)) {
				query.append(" and district like '%" + district + "%'");
			}
			if (!StringUtils.isNullOrEmpty(ward)) {
				query.append(" and ward like '%" + ward + "%'");
			}
			if (floorArea != null) {
				query.append(" and floorarea like '%" + floorArea + "%'");
			}

			// System.out.println("query: " + query);

			// Step 1: Load driver
			// Old (deprecated)
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Create connection
			// conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn = ConnectionUtils.getConnection();

			// Step 3: initialize statmenet (Khoi tao doi tuong)
			stmt = conn.createStatement();

			// Step 4: Execute sql (thuc thi cau sql)
			rs = stmt.executeQuery(query.toString());

			while (rs.next()) {
				BuildingAnhyeuem buildingAnhyeuem = new BuildingAnhyeuem();

				buildingAnhyeuem.setName(rs.getString("name"));
				buildingAnhyeuem.setStreet(rs.getString("street"));
				buildingAnhyeuem.setDistrict(rs.getString("district"));
				buildingAnhyeuem.setWard(rs.getString("ward"));
				buildingAnhyeuem.setFloorArea(rs.getInt("floorarea"));
				// buildingAnhyeuem.setBasement(rs.getInt("basement"));

				// results[i] = buildingAnhyeuem;
				results.add(buildingAnhyeuem);
			}

			// System.out.println("results2: " + results);

			return results;

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Always run this after run all above
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		return new ArrayList<>();
	}

	@Override
	public Long insert(BuildingAnhyeuem buildingAnhyeuem, String rentAreas) {

//		System.out.println("go to this");
		
		ResultSet resultSet = null;
		Connection conn = null;
		Statement stmt = null;
		
		Long buildingId = null;
		
		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();

			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO building(name, street) VALUES ('" + buildingAnhyeuem.getName() + "', '"
					+ buildingAnhyeuem.getStreet() + "')";
			System.out.println("sql: " + sql);
			
			int flag = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			resultSet = stmt.getGeneratedKeys();
			
			//System.out.println("flag: " + flag);
			if (flag > 0) {
				while (resultSet.next()) {
					buildingId = resultSet.getLong(1);
//			        String name = resultSet.getString("name");
//			        System.out.println("Building ID: " + buildingId + ", Name: " + name);
				}
				//System.out.println("buildingId: " + buildingId);
			}
			
			
			if (rentAreas.length() > 0) {
				for (String item : rentAreas.split(",")) {
					String sql2 = "INSERT INTO rentarea(value, buildingid) VALUES (" + Integer.parseInt(item) + ","
							+ buildingId + ")";
					stmt.executeUpdate(sql2);
					System.out.println("sql2: " + sql2);
				}
			}
			conn.commit();
			return buildingId;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
				stmt.close();
				resultSet.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return null;
	}

}