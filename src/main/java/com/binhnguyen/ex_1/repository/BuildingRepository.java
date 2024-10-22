package com.binhnguyen.ex_1.repository;

import java.util.List;

import com.binhnguyen.ex_1.repository.entity.BuildingEntity;

public interface BuildingRepository extends JdbcRepository<BuildingEntity> {
//	List<BuildingEntity> showBuilding(String name, String street, String ward, String district, Integer floorare);
	
	List<BuildingEntity> findBuilding(String name, String street, String district, String ward,Integer floorarea);
}
