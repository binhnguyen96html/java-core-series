package com.binhnguyen.ex_1.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.binhnguyen.ex_1.annotation.Column;
import com.binhnguyen.ex_1.annotation.Entity;
import com.binhnguyen.ex_1.annotation.Table;
import com.binhnguyen.ex_1.mapper.ResultsetMapper;
import com.binhnguyen.ex_1.repository.JdbcRepository;
import com.binhnguyen.ex_1.utils.ConnectionUtils;

public class SimpleJdbcRepository<T> implements JdbcRepository<T> {

	private Class<T> tClass;

	public SimpleJdbcRepository() {
		tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll() {
		List<T> results = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();

			String tableName = null;

			if (tClass.isAnnotationPresent(Entity.class) && tClass.isAnnotationPresent(Table.class)) {
				Table table = tClass.getAnnotation(Table.class);
				tableName = table.name();
			}

			String sql = "select * from " + tableName + "";
			rs = stmt.executeQuery(sql);

			ResultsetMapper<T> resultsetMapper = new ResultsetMapper<>();

			//System.out.println("sql: " + sql);

			return resultsetMapper.mapRow(rs, tClass);

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		return results;

	}

	@Override
	public void insert(Object object) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtils.getConnection();
			StringBuilder sql = createSQLInsert();
			stmt = conn.prepareStatement(sql.toString());
			Class<?> zClass = object.getClass();
			Field[] fields = zClass.getDeclaredFields();
			int parameterIndex = 1;
			for (Field field : fields) {
				field.setAccessible(true);
				stmt.setObject(parameterIndex, field.get(object));
				parameterIndex++;
			}
			Class<?> parentClass = zClass.getSuperclass();
//			Field[] fieldParents = parentClass.getDeclaredFields();
			int indexParent = fields.length + 1;
			while (parentClass != null) {
				for (Field field : parentClass.getDeclaredFields()) {
					field.setAccessible(true);
					stmt.setObject(indexParent, field.get(object));
					indexParent++;
				}
				parentClass = parentClass.getSuperclass();
			}
			stmt.executeUpdate();
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private StringBuilder createSQLInsert() {
		String tableName = "";
		if (tClass.isAnnotationPresent(Entity.class) && tClass.isAnnotationPresent(Table.class)) {
			Table table = tClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder("");
		StringBuilder values = new StringBuilder("");
		for (Field field : tClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				values.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				values.append("?");
			}
		}
		Class<?> parentClass = tClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (fields.length() > 1) {
					fields.append(",");
					values.append(",");
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					values.append("?");
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		StringBuilder sql = new StringBuilder(
				"insert into " + tableName + "(" + fields.toString() + ") values (" + values + ")");
		return sql;
	}

	@Override
	public T findById(Long id) {
		List<T> results = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();

			String tableName = null;

			if (tClass.isAnnotationPresent(Entity.class) && tClass.isAnnotationPresent(Table.class)) {
				Table table = tClass.getAnnotation(Table.class);
				tableName = table.name();
			}

			String sql = "select * from " + tableName + " where id = " + id;
			rs = stmt.executeQuery(sql);

			// System.out.println("sql: " + sql);

			ResultsetMapper<T> resultsetMapper = new ResultsetMapper<>();

			results = resultsetMapper.mapRow(rs, tClass);

			return results.size() > 0 ? results.get(0) : null;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		return null;
	}

	@Override
	public List<T> findByCondition(String sql) {
		List<T> results = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			ResultsetMapper<T> resultsetMapper = new ResultsetMapper<>();

			System.out.println("sql: " + sql);

			return resultsetMapper.mapRow(rs, tClass);

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		return results;
	}

	@Override
	public void update(Long id, Object object) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionUtils.getConnection();
			StringBuilder sql = createSQLUpdate(id);
			stmt = conn.prepareStatement(sql.toString());
			Class<?> zClass = object.getClass();
			Field[] fields = zClass.getDeclaredFields();
			int parameterIndex = 1;
			for (Field field : fields) {
				field.setAccessible(true);
				stmt.setObject(parameterIndex, field.get(object));
				parameterIndex++;
			}
			Class<?> parentClass = zClass.getSuperclass();
			// Field[] fieldParents = parentClass.getDeclaredFields();
			int indexParent = fields.length + 1;
			while (parentClass != null) {
				for (Field field : parentClass.getDeclaredFields()) {
					field.setAccessible(true);
					stmt.setObject(indexParent, field.get(object));
					indexParent++;
				}
				parentClass = parentClass.getSuperclass();
			}
			stmt.executeUpdate();
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}// update

	private StringBuilder createSQLUpdate(Long id) {
		String tableName = "";
		if (tClass.isAnnotationPresent(Entity.class) && tClass.isAnnotationPresent(Table.class)) {
			Table table = tClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder("");
		for (Field field : tClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				fields.append("=");
				fields.append("?");
			}
		}
		Class<?> parentClass = tClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (fields.length() > 1) {
					fields.append(",");
				}
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					fields.append(column.name());
					fields.append("=");
					fields.append("?");
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET " + fields.toString() + " WHERE id=" + id);
		// System.out.println("sql: " + sql);
		return sql;
	}// createSQLUpdate

	@Override
	public void delete(Long id) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			String tableName = null;
			if (tClass.isAnnotationPresent(Entity.class) && tClass.isAnnotationPresent(Table.class)) {
				Table table = tClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			String sql = "DELETE from "+tableName+" WHERE id="+id;
			//System.out.println("sql: " + sql);
			
			//stmt.executeQuery(sql);
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}// delete

}
