package com.example.jdbc.View;

import com.example.jdbc.controller.BuildingController;
import com.example.jdbc.dto.BuildingDTO;

public class BuildingEditView {

  public static void main(String[] args) {
    BuildingController buildingController = new BuildingController();

    BuildingDTO newBuilding = new BuildingDTO();
    
    buildingController.insert(newBuilding);
  }
}
