package com.spring.jdbc.service;

import java.util.List;

import com.spring.jdbc.entitiy.Student;

public interface StudentService {

	public Student saveStudent(Student student);

	public Student getStudentById(Integer id);

	public List<Student> getList();
	public Integer deleteStudent(Integer id);

}
