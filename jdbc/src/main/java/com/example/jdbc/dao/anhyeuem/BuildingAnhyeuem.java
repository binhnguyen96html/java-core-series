package com.example.jdbc.dao.anhyeuem;

public class BuildingAnhyeuem {

  private Long id;
  private String name ;
  private String street ;
  private String district ;
  private String ward ;
  private Integer floorArea ;


 

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public Integer getFloorArea() {
    return this.floorArea;
  }

  public void setFloorArea(Integer floorArea) {
    this.floorArea = floorArea;
  }
  

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", street='" + getStreet() + "'" +
      ", district='" + getDistrict() + "'" +
      ", ward='" + getWard() + "'" +
      ", floorArea='" + getFloorArea() + "'" +
      "}";
  }
  

}
