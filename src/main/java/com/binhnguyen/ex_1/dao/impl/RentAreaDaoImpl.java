package com.binhnguyen.ex_1.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.binhnguyen.ex_1.dao.RentAreaDao;
import com.binhnguyen.ex_1.dao.anhyeuem.RentAreaAnhyeuem;
import com.binhnguyen.ex_1.utils.ConnectionUtils;

public class RentAreaDaoImpl implements RentAreaDao {

	@Override
	public void insert(RentAreaAnhyeuem areaAnhyeuem) {
		System.out.println("go to this 2");
		try (Connection conn = ConnectionUtils.getConnection(); Statement stmt = conn.createStatement();) {
			String sql = "INSERT INTO rentarea(value, buildingid) VALUES (" + areaAnhyeuem.getValue() + ","
					+ areaAnhyeuem.getBuildingId() + ")";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}