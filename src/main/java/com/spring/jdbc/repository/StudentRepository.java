package com.spring.jdbc.repository;

import java.util.List;

import com.spring.jdbc.entitiy.Student;

public interface StudentRepository {

	public Student saveStudent(Student student);

	public Student getStudentById(Integer id);

	public List<Student> getList();

}
