package com.binhnguyen.ex_1.model.dto;

public class BuildingDTO {
	
	private Long id;
	private String name;
	private String street;
	private String ward;
	private Integer floorarea;
	private Integer rentPrice;
	
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	private long districtid;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public long getDistrictid() {
		return districtid;
	}
	public void setDistrictid(long districtid) {
		this.districtid = districtid;
	}
	

}
