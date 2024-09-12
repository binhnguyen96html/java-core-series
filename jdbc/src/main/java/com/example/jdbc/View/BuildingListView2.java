package com.example.jdbc.View;

import java.util.List;

import com.example.jdbc.controller.BuildingController;
import com.example.jdbc.input.BuildingSearchInput2;
import com.example.jdbc.output.BuildingOutput2;

public class BuildingListView2 {

  public static void main(String[] args) {

    String name = null;
    String street = null;
    String district = null;
    String ward = null;
    Integer floorArea = null;
    String type = null;


    // String name = "name1";
		// String street = "street1";
		// String district = "district1";
		// String ward = "ward1";
		// Integer floorArea = 100;
    // String type = null;


    // BuildingModel buildingSearch = new BuildingModel();
    BuildingSearchInput2 buildingSearch = new BuildingSearchInput2();

    buildingSearch.setName(name);
    buildingSearch.setStreet(street);
    buildingSearch.setDistrict(district);
    buildingSearch.setWard(ward);
    buildingSearch.setFloorArea(floorArea);
    buildingSearch.setType(type);


    BuildingController buildingController = new BuildingController();
    // System.out.println("buildingsearch: " + buildingSearch.toString());
    // BuildingModel[] buildings = buildingController.findBuilding(buildingSearch);
    List<BuildingOutput2> buildings = buildingController.findBuilding2(buildingSearch);


    for(BuildingOutput2 item: buildings){
      System.out.print(item.getName());
      System.out.println(", " + item.getAddress());
      System.out.println("Type: " + item.getType());
      System.out.println();
    }
  }
}
