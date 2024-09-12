package com.example.jdbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.jdbc.dao.BuildingDao;
import com.example.jdbc.dao.BuildingDao2;
import com.example.jdbc.dao.anhyeuem.BuildingAnhyeuem;
import com.example.jdbc.dao.anhyeuem.BuildingAnhyeuem2;
import com.example.jdbc.dao.impl.BuildingDaoImpl;
import com.example.jdbc.dao.impl.BuildingDaoImpl2;
import com.example.jdbc.input.BuildingSearchInput;
import com.example.jdbc.input.BuildingSearchInput2;
import com.example.jdbc.output.BuildingOutput;
import com.example.jdbc.output.BuildingOutput2;
import com.example.jdbc.service.BuildingService;

public class BuildingServiceImpl implements BuildingService{

  private BuildingDao buildingDao = new BuildingDaoImpl();
  private BuildingDao2 buildingDao2 = new BuildingDaoImpl2();
  
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

  @Override
  public List<BuildingOutput2> findBuilding2(BuildingSearchInput2 buildingModel){
     List<BuildingOutput2> buildingOutputs = new ArrayList<>();

     List<BuildingAnhyeuem2> anhyeuems = buildingDao2.findBuilding(
      buildingModel.getName(),
      buildingModel.getStreet(),
      buildingModel.getDistrict(),
      buildingModel.getWard(),
      buildingModel.getFloorArea(),
      buildingModel.getType()
     );

     for(BuildingAnhyeuem2 item: anhyeuems){
      BuildingOutput2 buildingOutput = new BuildingOutput2();
      buildingOutput.setName(item.getName());
      buildingOutput.setAddress(item.getStreet() + " ," + item.getDistrict() + " ," + item.getWard());
      buildingOutput.setType(item.getType());

      buildingOutputs.add(buildingOutput);
     }


     return buildingOutputs;
  }
}
