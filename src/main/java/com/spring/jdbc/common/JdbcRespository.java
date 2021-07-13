package com.spring.jdbc.common;

import java.util.List;

import com.spring.jdbc.entitiy.Student;

public interface JdbcRespository<T extends JdbcEntity> {

	public List<Student> findAll();

	public T findById(Integer id);

	public Integer delete(Integer id);

}
