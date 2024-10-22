package com.binhnguyen.ex_1.repository.entity;

import com.binhnguyen.ex_1.annotation.Column;
import com.binhnguyen.ex_1.annotation.Entity;
import com.binhnguyen.ex_1.annotation.Table;

@Entity
@Table(name="building")
public class BuildingEntity extends BaseEntity {

	@Column(name = "name")
	 private String name;
	
	@Column(name = "street")
	 private String street;
	
	@Column(name = "ward")
	 private String ward;
	
	@Column(name = "floorarea")
	private Integer floorarea;
	
	@Column(name = "districtid")
	 private Long districtid;
	
	@Column(name = "rentprice")
	private Integer rentPrice;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
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

	public Integer getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}

	public Long getDistrictid() {
		return districtid;
	}

	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}
	
}
