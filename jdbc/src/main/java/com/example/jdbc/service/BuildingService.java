package com.example.jdbc.service;

import java.util.List;

import com.example.jdbc.input.BuildingSearchInput;
import com.example.jdbc.output.BuildingOutput;

public interface  BuildingService {
  List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel);
}
