package com.binhnguyen.ex_1.controller;

import java.util.List;

import com.binhnguyen.ex_1.model.dto.BuildingDTO;
import com.binhnguyen.ex_1.service.BuildingService;
import com.binhnguyen.ex_1.service.impl.BuildingServiceImpl;


public class BuildingController {
	
	private BuildingService buildingService = new BuildingServiceImpl();
	
	public List<BuildingDTO> findAll(){
		return buildingService.findAll();
	};
	
	public List<BuildingDTO> findBuilding(String name, String street, String district, String ward, Integer floorarea){
		return buildingService.findBuilding(name, street, district, ward, floorarea);
	}
	
	public void insertBuilding(BuildingDTO buildingDTO) {
		buildingService.insert(buildingDTO);
	}
	
	public BuildingDTO findById(Long id) {
		return buildingService.findById(id);
	}
	
	public void updateBuilding(Long id, BuildingDTO buildingDTO) {
		buildingService.update(id, buildingDTO);
	}
	
	public void deleteBuilding(Long id) {
		buildingService.delete(id);
	}
	  
}
