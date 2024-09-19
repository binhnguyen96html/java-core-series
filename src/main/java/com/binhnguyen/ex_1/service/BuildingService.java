package com.binhnguyen.ex_1.service;


import java.util.List;

import com.binhnguyen.ex_1.dto.BuildingDTO;
import com.binhnguyen.ex_1.input.BuildingSearchInput;
import com.binhnguyen.ex_1.output.BuildingOutput;



public interface  BuildingService {
  List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel);
  //save() cho edit and update
  void save(BuildingDTO buildingDTO);
}