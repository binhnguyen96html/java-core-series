package com.example.jdbc.View;

import java.util.List;

import com.example.jdbc.controller.BuildingController;
import com.example.jdbc.input.BuildingSearchInput;
import com.example.jdbc.output.BuildingOutput;

public class BuildingListView {

  public static void main(String[] args) {

    // String name = "1";
    // String street = null;
    // String district = null;
    // String ward = null;
    // Integer floorArea = null;


    String name = "name1";
		String street = "street1";
		String district = "district1";
		String ward = "ward1";
		Integer floorArea = 100;

    // BuildingModel buildingSearch = new BuildingModel();
    BuildingSearchInput buildingSearch = new BuildingSearchInput();

    buildingSearch.setName(name);
    buildingSearch.setStreet(street);
    buildingSearch.setDistrict(district);
    buildingSearch.setWard(ward);
    buildingSearch.setFloorArea(floorArea);


    BuildingController buildingController = new BuildingController();
    // System.out.println("buildingsearch: " + buildingSearch.toString());
    // BuildingModel[] buildings = buildingController.findBuilding(buildingSearch);
    List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearch);


    for(BuildingOutput item: buildings){
      System.out.println(item.getName());
      System.out.println(item.getAddress());
    }
  }
}
