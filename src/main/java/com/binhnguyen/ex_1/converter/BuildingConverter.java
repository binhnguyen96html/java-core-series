package com.binhnguyen.ex_1.converter;

import com.binhnguyen.ex_1.dao.anhyeuem.BuildingAnhyeuem;
import com.binhnguyen.ex_1.dto.BuildingDTO;
import com.binhnguyen.ex_1.output.BuildingOutput;

public class BuildingConverter {

	public BuildingOutput converFromAnhyeuemToOutput(BuildingAnhyeuem buildingAnhyeuem) {
		BuildingOutput result = new BuildingOutput();
		result.setName(buildingAnhyeuem.getName());
		result.setAddress(buildingAnhyeuem.getStreet() + " ," + buildingAnhyeuem.getDistrict() + " ,"
				+ buildingAnhyeuem.getWard());
		return result;
	}
	
	public BuildingAnhyeuem convertFromDtoToAnhyeuem(BuildingDTO buildingDTO) {
		BuildingAnhyeuem result = new BuildingAnhyeuem();
		result.setName(buildingDTO.getName());
		result.setStreet(buildingDTO.getStreet());
		return result;
	}
}
