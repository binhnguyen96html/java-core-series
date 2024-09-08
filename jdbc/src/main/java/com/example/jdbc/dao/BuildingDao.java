package com.example.jdbc.dao;

import java.util.List;

import com.example.jdbc.dao.anhyeuem.BuildingAnhyeuem;

public interface BuildingDao {
  List<BuildingAnhyeuem> findBuilding(
    String name, 
    String street, 
    String district, 
    String ward, 
    Integer floorArea
    );
}
