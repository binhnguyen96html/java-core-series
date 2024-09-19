package com.binhnguyen.ex_1.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.binhnguyen.ex_1.converter.BuildingConverter;
import com.binhnguyen.ex_1.dao.BuildingDao;
import com.binhnguyen.ex_1.dao.anhyeuem.BuildingAnhyeuem;
import com.binhnguyen.ex_1.dao.impl.BuildingDaoImpl;
import com.binhnguyen.ex_1.dto.BuildingDTO;
import com.binhnguyen.ex_1.input.BuildingSearchInput;
import com.binhnguyen.ex_1.output.BuildingOutput;
import com.binhnguyen.ex_1.service.BuildingService;



public class BuildingServiceImpl implements BuildingService{

  private BuildingDao buildingDao = new BuildingDaoImpl();
//  private RentAreaDao rentAreaDao = new RentAreaDaoImpl();
  private BuildingConverter buildingConverter = new BuildingConverter();
  
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

    //anhyeuem -> output
      BuildingOutput buildingOutput = buildingConverter.converFromAnhyeuemToOutput(item);
      
      buildingOutputs.add(buildingOutput);
    }
    
    return buildingOutputs;
  }

  
  @Override
  public void save(BuildingDTO  buildingDTO) {
//	  System.out.println(" buildingDTO.getId(): " + buildingDTO.getId());
	  if(buildingDTO.getId() == null) {
		  //dto -> anhyeuem
		  BuildingAnhyeuem buildingAnhyeuem = buildingConverter.convertFromDtoToAnhyeuem(buildingDTO);

//		  Long buildingId = buildingDao.insert(buildingAnhyeuem);
//		  if(buildingDTO.getRentAreas().length() > 0) {
//			  for(String item: buildingDTO.getRentAreas().split(",")) {
//				  RentAreaAnhyeuem rentAreaAnhyeuem = new RentAreaAnhyeuem();
//				  rentAreaAnhyeuem.setValue(Integer.parseInt(item));
//				  rentAreaAnhyeuem.setBuildingId(buildingId);
//				  rentAreaDao.insert(rentAreaAnhyeuem);
//			  }	 
//		  }
  
		  buildingDao.insert(buildingAnhyeuem, buildingDTO.getRentAreas());
	  }else {
		  //update
	  }
  }
  
}