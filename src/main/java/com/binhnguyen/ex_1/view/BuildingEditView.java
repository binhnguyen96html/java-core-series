package com.binhnguyen.ex_1.view;

import com.binhnguyen.ex_1.repository.BuildingRepository;
import com.binhnguyen.ex_1.repository.entity.BuildingEntity;
import com.binhnguyen.ex_1.repository.impl.BuildingRepositoryImpl;

public class BuildingEditView {

	public static void main(String[] args) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setName("abc");
		buildingEntity.setFloorarea(123);
		BuildingRepository buildingRepository = new BuildingRepositoryImpl();
		buildingRepository.insert(buildingEntity);
	}
}
