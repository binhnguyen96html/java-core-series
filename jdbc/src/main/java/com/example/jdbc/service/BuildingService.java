package com.example.jdbc.service;

import java.util.List;

import com.example.jdbc.input.BuildingSearchInput;
import com.example.jdbc.input.BuildingSearchInput2;
import com.example.jdbc.output.BuildingOutput;
import com.example.jdbc.output.BuildingOutput2;

public interface  BuildingService {
  List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel);
  List<BuildingOutput2> findBuilding2(BuildingSearchInput2 buildingModel);
}
