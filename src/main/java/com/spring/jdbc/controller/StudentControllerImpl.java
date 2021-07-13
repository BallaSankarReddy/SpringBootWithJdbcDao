package com.spring.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.spring.jdbc.entitiy.Student;
import com.spring.jdbc.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentControllerImpl {
	
	@Autowired
	Example e ;
	
	
	
	@GetMapping
	public String apiMethod1() {

		
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		
		System.out.println(request);
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		if(requestURI.replace("/", "").contains("greating")) {
			return e.hello();
		}
		
		return e.hello1();
	}
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/student/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable("id") Integer id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/student/get/{id}")
	public Student getStudents(@RequestParam ("id") Integer id) {
		return studentService.getStudentById(id);
	}

	@GetMapping("/student/all")
	public List<Student> getList() {
		return studentService.getList();
	}

	
	@DeleteMapping("/student/dete/{id}")
	public Integer deleteStudent(@PathVariable("id") Integer id) {
		return studentService.deleteStudent(id);
	}
}
