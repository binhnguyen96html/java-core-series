package com.binhnguyen.ex_1.view;


import com.binhnguyen.ex_1.controller.BuildingController;
import com.binhnguyen.ex_1.dto.BuildingDTO;


public class BuildingEditView {

  public static void main(String[] args) {

	//input data
//    String name = null;
//    String street = null;
//    String district = null;
//    String ward = null;
//    Long floorArea = null;
//    String rentAreas = null;

    // String name = "name1";
    String name = "building h";
    String street = "street h";
    String district = null;
    String ward = null;
    Long floorArea = null;
    String rentAreas = "100,200,300";

   // set data for new building
    BuildingDTO newBuilding = new BuildingDTO();
    newBuilding.setName(name);
    newBuilding.setStreet(street);
    newBuilding.setDistrict(district);
    newBuilding.setWard(ward);
    newBuilding.setFloorArea(floorArea);
    newBuilding.setRentAreas(rentAreas);


    BuildingController buildingController = new BuildingController();
    buildingController.addBuilding(newBuilding);
 
  }
}
