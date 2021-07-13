package com.spring.jdbc.entitiy;

import com.spring.jdbc.common.JdbcEntity;

public class Student implements JdbcEntity {

	private Integer id;
	private String name;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String getTableName() {
		return "student_Data";
	}

	@Override
	public String getEntityIdColumn() {
		return "id";
	}

}
