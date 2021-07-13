package com.spring.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jdbc.entitiy.Student;
import com.spring.jdbc.repository.StudentRepositoryImpl;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepositoryImpl studentRepository;

	@Override
	public Student saveStudent(Student student) {

		Student saveStudent = studentRepository.saveStudent(student);
		return saveStudent;
	}

	@Override
	public Student getStudentById(Integer id) {
		
		//deleteStudent(id);
		Student student = studentRepository.getStudentById(id);
		return student;
	}

	@Override
	public Integer deleteStudent(Integer id) {
		studentRepository.delete(id);
		return id;
	}

	@Override
	public List<Student> getList() {
		return studentRepository.findAll();
	}
	

}
