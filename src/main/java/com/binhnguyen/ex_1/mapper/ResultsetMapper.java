package com.binhnguyen.ex_1.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.binhnguyen.ex_1.annotation.Column;

public class ResultsetMapper<T> {

	public List<T> mapRow(ResultSet rs, Class<T> tClass){
		
		List<T> results = new ArrayList<>();
		
		try {
			Field[] fields = tClass.getDeclaredFields();
			
			ResultSetMetaData resultSetMetaData = rs.getMetaData();

			while (rs.next()) {
				/*
				 * BuildingEntity buildingEntity = new BuildingEntity();
				 * 
				 * buildingEntity.setName(rs.getString("name"));
				 * buildingEntity.setFloorArea(rs.getInt("floorarea"));
				 * buildingEntity.setStreet(rs.getString("street"));
				 * 
				 * results.add(buildingEntity);
				 */
				
				//BuldingEntity object = new BuildingEntity()
				T object = tClass.newInstance();
				
				for(int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
					
					String columnName = resultSetMetaData.getColumnName(i+1);
					Object columnValue = rs.getObject(i + 1);
					
					for(Field field: fields) {
						
						if(field.isAnnotationPresent(Column.class)) {// Kiểm tra xem Field có được chú thích với @Column hay không
							
							Column column = field.getAnnotation(Column.class);// Lấy annotation @Column từ Field
							
							if(column.name().equals(columnName) && columnValue != null) {// So sánh tên cột trong database với tên cột trong annotation @Column
								//field.getName(): là lấy private Long id - không phải @Column(name = "id")
								BeanUtils.setProperty(object, field.getName(), columnValue);// Sử dụng BeanUtils để thiết lập giá trị cho thuộc tính của đối tượng
								break;
							}
						}
					}//for
					
					Class<?> parentClass = tClass.getSuperclass();
					while(parentClass != null) {
						for(Field field: parentClass.getDeclaredFields()) {
							
							if(field.isAnnotationPresent(Column.class)) {// Kiểm tra xem Field có được chú thích với @Column hay không
								
								Column column = field.getAnnotation(Column.class);// Lấy annotation @Column từ Field
								
								if(column.name().equals(columnName) && columnValue != null) {// So sánh tên cột trong database với tên cột trong annotation @Column
									
									//field.getName(): là lấy private Long id - không phải @Column(name = "id")
									BeanUtils.setProperty(object, field.getName(), columnValue);// Sử dụng BeanUtils để thiết lập giá trị cho thuộc tính của đối tượng
									break;
								}
							}
						}//for
						
						parentClass = parentClass.getSuperclass();
					}
					
				}//for
				
				results.add(object);
			}//while
		} catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			// TODO: handle exception
		};
		
		return results;
	}
}
