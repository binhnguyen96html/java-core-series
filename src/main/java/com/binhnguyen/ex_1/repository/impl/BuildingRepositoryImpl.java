package com.binhnguyen.ex_1.repository.impl;

import java.util.List;

import com.binhnguyen.ex_1.constant.SystemConstant;
import com.binhnguyen.ex_1.repository.BuildingRepository;
import com.binhnguyen.ex_1.repository.entity.BuildingEntity;
import com.binhnguyen.ex_1.utils.StringUtils;

public class BuildingRepositoryImpl extends SimpleJdbcRepository<BuildingEntity> implements BuildingRepository {

	@Override
	public List<BuildingEntity> findBuilding(String name, String street, String district, String ward,
			Integer floorarea) {

		StringBuilder query = new StringBuilder("SELECT * FROM building " + SystemConstant.ONE_EQUAL_ONE);

		if (!StringUtils.isNullOrEmpty(name)) {
			query.append(" and name like '%" + name + "%'");
		}
		if (!StringUtils.isNullOrEmpty(street)) {
			query.append(" and street like '%" + street + "%'");
		}
		if (!StringUtils.isNullOrEmpty(district)) {
			query.append(" and district like '%" + district + "%'");
		}
		if (!StringUtils.isNullOrEmpty(ward)) {
			query.append(" and ward like '%" + ward + "%'");
		}
		if (floorarea != null) {
			query.append(" and floorarea like '%" + floorarea + "%'");
		}

		//System.out.println("query: " + query);

		return findByCondition(query.toString());
	}

}
