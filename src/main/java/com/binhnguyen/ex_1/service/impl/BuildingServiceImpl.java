package com.binhnguyen.ex_1.service.impl;


import java.util.ArrayList;
import java.util.List;


import com.binhnguyen.ex_1.model.dto.BuildingDTO;
import com.binhnguyen.ex_1.repository.BuildingRepository;
import com.binhnguyen.ex_1.repository.entity.BuildingEntity;
import com.binhnguyen.ex_1.repository.impl.BuildingRepositoryImpl;
import com.binhnguyen.ex_1.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {
	
	private BuildingRepository buildingDao = new BuildingRepositoryImpl();

	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingDTO> results = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingDao.findAll();
		
//		System.out.println("buildingEntities: " + buildingEntities);
		for(BuildingEntity item: buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setName(item.getName());
			
			results.add(buildingDTO);			
		}
		
		return results;
	}

	@Override
	public List<BuildingDTO> findBuilding(String name, String street, String district, String ward, Integer floorarea) {
		
		List<BuildingDTO> results = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingDao.findBuilding(name, street, district, ward, floorarea);
		
		for(BuildingEntity item: buildingEntities) {
			BuildingDTO buildingDTO = new BuildingDTO();
			buildingDTO.setName(item.getName());
			
			results.add(buildingDTO);			
		}
		
		return results;
	}

	@Override
	public void insert(BuildingDTO buildingDTO) {
		
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setName(buildingDTO.getName());
		buildingEntity.setStreet(buildingDTO.getStreet());
		buildingEntity.setWard(buildingDTO.getWard());
		buildingEntity.setFloorarea(buildingDTO.getFloorarea());
		buildingEntity.setDistrictid(buildingDTO.getDistrictid());
		buildingEntity.setRentPrice(buildingDTO.getRentPrice());
		
		buildingDao.insert(buildingEntity);
	}

	@Override
	public BuildingDTO findById(Long id) {
		
		BuildingDTO buildingDTO = new BuildingDTO();
		BuildingEntity buildingEntity = buildingDao.findById(id);
		
		buildingDTO.setId(buildingEntity.getId());
		buildingDTO.setName(buildingEntity.getName());
		buildingDTO.setStreet(buildingEntity.getStreet());
		buildingDTO.setWard(buildingEntity.getWard());
		buildingDTO.setFloorarea(buildingEntity.getFloorarea());
		buildingDTO.setDistrictid(buildingEntity.getDistrictid());
		buildingDTO.setRentPrice(buildingEntity.getRentPrice());
		
		return buildingDTO;
	}

	@Override
	public void update(Long id, BuildingDTO buildingDTO) {
		
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setId(buildingDTO.getId());
		buildingEntity.setName(buildingDTO.getName());
		buildingEntity.setStreet(buildingDTO.getStreet());
		buildingEntity.setWard(buildingDTO.getWard());
		buildingEntity.setFloorarea(buildingDTO.getFloorarea());
		buildingEntity.setDistrictid(buildingDTO.getDistrictid());
		buildingEntity.setRentPrice(buildingDTO.getRentPrice());
		
		buildingDao.update(id, buildingEntity);		
	}

	@Override
	public void delete(Long id) {
		buildingDao.delete(id);
	}


}