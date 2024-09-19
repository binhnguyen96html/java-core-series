package com.binhnguyen.ex_1.controller;

import java.util.List;

import com.binhnguyen.ex_1.dto.BuildingDTO;
import com.binhnguyen.ex_1.input.BuildingSearchInput;
import com.binhnguyen.ex_1.output.BuildingOutput;
import com.binhnguyen.ex_1.service.BuildingService;
import com.binhnguyen.ex_1.service.impl.BuildingServiceImpl;


public class BuildingController {

	  private BuildingService buildingService = new BuildingServiceImpl();
	  
	  public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearch){
	    List<BuildingOutput> buildingModels = buildingService.findBuilding(buildingSearch);
	    return buildingModels;
	  }

	  public BuildingDTO addBuilding(BuildingDTO newBuilding){
		  buildingService.save(newBuilding);
	    return null;
	  }
	  
}
