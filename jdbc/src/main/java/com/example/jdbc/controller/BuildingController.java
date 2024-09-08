package com.example.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.jdbc.dto.BuildingDTO;
import com.example.jdbc.input.BuildingSearchInput;
import com.example.jdbc.output.BuildingOutput;
import com.example.jdbc.service.BuildingService;
import com.example.jdbc.service.impl.BuildingServiceImpl;

public class BuildingController {

  private BuildingService buildingService = new BuildingServiceImpl();
  
  public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearch){

    // BuildingModel[] buildingModels = new BuildingModel[5];
    List<BuildingOutput> buildingModels = buildingService.findBuilding(buildingSearch);

    return buildingModels;
  }

  public BuildingDTO insert(BuildingDTO newBuilding){
    return null;
  }
}
