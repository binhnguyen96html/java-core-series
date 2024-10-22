package com.binhnguyen.ex_1.service;

import java.util.List;

import com.binhnguyen.ex_1.model.dto.BuildingDTO;


public interface BuildingService {

	List<BuildingDTO> findAll();
	
	List<BuildingDTO> findBuilding(String name, String street, String district, String ward, Integer floorarea);
	
	void insert(BuildingDTO buildingDTO);
	
	BuildingDTO findById(Long id);
	
	void update(Long id, BuildingDTO buildingDTO);
	
	void delete(Long id);
}