package com.example.jdbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.jdbc.dao.BuildingDao;
import com.example.jdbc.dao.anhyeuem.BuildingAnhyeuem;
import com.example.jdbc.dao.impl.BuildingDaoImpl;
import com.example.jdbc.input.BuildingSearchInput;
import com.example.jdbc.output.BuildingOutput;
import com.example.jdbc.service.BuildingService;

public class BuildingServiceImpl implements BuildingService{

  private BuildingDao buildingDao = new BuildingDaoImpl();
  
  @Override
  public List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel){

    // BuildingEmyeuanh[] emyeuanhs = new BuildingEmyeuanh[5];
    List<BuildingOutput> buildingOutputs = new ArrayList<>();

    List<BuildingAnhyeuem> anhyeuems = buildingDao.findBuilding(
      buildingModel.getName(),
      buildingModel.getStreet(),
      buildingModel.getDistrict(),
      buildingModel.getWard(),
      buildingModel.getFloorArea()
      // buildingModel.getNumberOfBasement()
    );


    for(BuildingAnhyeuem item: anhyeuems){
      // System.out.println("item: " + item);

      BuildingOutput buildingOutput = new BuildingOutput();
      buildingOutput.setName(item.getName());
      buildingOutput.setAddress(item.getStreet() + " ," + item.getDistrict() + " ," + item.getWard());

      // emyeuanhs[i] = buildingEmyeuanh;
      buildingOutputs.add(buildingOutput);
    }
    
    return buildingOutputs;
  }
}
