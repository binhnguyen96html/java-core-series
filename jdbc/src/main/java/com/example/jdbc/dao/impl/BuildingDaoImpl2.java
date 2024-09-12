package com.example.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbc.constant.SystemConstant;
import com.example.jdbc.dao.BuildingDao2;
import com.example.jdbc.dao.anhyeuem.BuildingAnhyeuem2;
import com.example.jdbc.utils.ConnectionUtils;

import ch.qos.logback.core.util.StringUtil;

public class BuildingDaoImpl2 implements BuildingDao2 {

  @Override
  public List<BuildingAnhyeuem2> findBuilding(
      String name,
      String street,
      String district,
      String ward,
      Integer floorArea,
      String type) {

    // BuildingAnhyeuem[] results = new BuildingAnhyeuem[3];
    List<BuildingAnhyeuem2> results = new ArrayList<>();

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      // Cong chuoi - StringBuilder
      StringBuilder query = new StringBuilder(
          "SELECT building.name, building.street, building.district, building.ward, building.floorarea, GROUP_CONCAT(bType.type SEPARATOR ', ') AS types FROM building "
          + " INNER JOIN building_bType ON building_bType.building_id = building.id"
          + " INNER JOIN bType ON building_bType.bType_id = bType.id "
          + SystemConstant.ONE_EQUAL_ONE
      );


      if (!StringUtil.isNullOrEmpty(name)) {
        query.append(" and name like '%" + name + "%'");
      }
      if (!StringUtil.isNullOrEmpty(street)) {
        query.append(" and street like '%" + street + "%'");
      }
      if (!StringUtil.isNullOrEmpty(district)) {
        query.append(" and district like '%" + district + "%'");
      }
      if (!StringUtil.isNullOrEmpty(ward)) {
        query.append(" and ward like '%" + ward + "%'");
      }
      if (floorArea != null) {
        query.append(" and floorarea like '%" + floorArea + "%'");
      }

      query.append(" GROUP BY building.name, building.street, building.district, building.ward, building.floorarea");

      System.out.println("query: " + query);

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
        BuildingAnhyeuem2 buildingAnhyeuem = new BuildingAnhyeuem2();

        buildingAnhyeuem.setName(rs.getString("name"));
        buildingAnhyeuem.setStreet(rs.getString("street"));
        buildingAnhyeuem.setDistrict(rs.getString("district"));
        buildingAnhyeuem.setWard(rs.getString("ward"));
        buildingAnhyeuem.setFloorArea(rs.getInt("floorarea"));
        buildingAnhyeuem.setType(rs.getString("types"));

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
}
