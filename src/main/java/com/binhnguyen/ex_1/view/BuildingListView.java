package com.binhnguyen.ex_1.view;

import java.util.List;

import com.binhnguyen.ex_1.controller.BuildingController;
import com.binhnguyen.ex_1.model.dto.BuildingDTO;

public class BuildingListView {

	public static void main(String[] args) {

		BuildingController buildingController = new BuildingController();

		//FIND ALL
//		System.out.println("findAll method-----------------------------------------------------------");
//		List<BuildingDTO> buildings = buildingController.findAll();
//		for (BuildingDTO item : buildings) {
//			System.out.println(item.getName());
//		}
		
		//INSERT
//		System.out.println("insert method-----------------------------------------------------------");
//		BuildingDTO buildingDTO_request = new BuildingDTO();
//		buildingDTO_request.setName("Building insert 2");
//		buildingDTO_request.setStreet("Street insert 2");
//		buildingDTO_request.setWard("Ward insert 1");
//		buildingDTO_request.setFloorarea(100);
//		buildingDTO_request.setDistrictid(1);
//		buildingDTO_request.setRentPrice(10);
//		
//		buildingController.insertBuilding(buildingDTO_request);
		
		//FIND BUILDING
//		System.out.println("findBuilding method-----------------------------------------------------------");		// findBuilding(String name, String street, String district, String ward, Integer floorarea)
//		String name = null;
//		String street = "phan xich long";
//		String district = null;
//		String ward = null;
//		Integer floorarea = null;
//		List<BuildingDTO> buildings2 = buildingController.findBuilding(name, street, district, ward, floorarea);
//		for (BuildingDTO item : buildings2) {
//			System.out.println(item.getName());
//		}
		
		//FIND BY ID
//		System.out.println("findById method-----------------------------------------------------------");		//findById()
//		BuildingDTO buildingById = buildingController.findById(16L);
//		System.out.println("buildingById - name:  " + buildingById.getName());
		
		
		//UPDATE BUILDING
		System.out.println("updateBuilding method-----------------------------------------------------------");		//updateBuilding()
		BuildingDTO buildingDTO_update = buildingController.findById(16L);
		buildingDTO_update.setName(buildingDTO_update.getName() + " updated" + " anhyeuem");		
		buildingController.updateBuilding(16L, buildingDTO_update);	
		System.out.println("updated name of building: " + buildingDTO_update.getName());
		
		//DELETE BUILDING
//		System.out.println("deleteBuilding method-----------------------------------------------------------");		//deleteBuilding()
//		buildingController.deleteBuilding(6L);
	}//main
}//class