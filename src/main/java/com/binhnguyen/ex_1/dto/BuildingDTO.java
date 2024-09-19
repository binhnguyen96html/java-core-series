package com.binhnguyen.ex_1.dto;


public class BuildingDTO extends BaseDTO {
  
  private String name ;
  private String street ;
  private String district ;
  private String ward ;
  private Long floorArea ;
  private String rentAreas;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet() {
    return this.street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getDistrict() {
    return this.district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getWard() {
    return this.ward;
  }

  public void setWard(String ward) {
    this.ward = ward;
  }

  public Long getFloorArea() {
    return this.floorArea;
  }

  public void setFloorArea(Long floorArea) {
    this.floorArea = floorArea;
  }

public String getRentAreas() {
	return rentAreas;
}

public void setRentAreas(String rentAreas) {
	this.rentAreas = rentAreas;
}

  
}
