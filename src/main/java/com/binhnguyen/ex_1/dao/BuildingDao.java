package com.binhnguyen.ex_1.dao;

import java.util.List;

import com.binhnguyen.ex_1.dao.anhyeuem.BuildingAnhyeuem;


public interface BuildingDao {
  List<BuildingAnhyeuem> findBuilding(
    String name, 
    String street, 
    String district, 
    String ward, 
    Integer floorArea
    );
  
  Long insert(BuildingAnhyeuem buildingAnhyeuem, String rentAreas);
}
