package com.example.jdbc.dao;

import java.util.List;

import com.example.jdbc.dao.anhyeuem.BuildingAnhyeuem2;

public interface BuildingDao2 {
  List<BuildingAnhyeuem2> findBuilding(
    String name, 
    String street, 
    String district, 
    String ward, 
    Integer floorArea,
    String type
    );
}
