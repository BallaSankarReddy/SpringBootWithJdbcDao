package com.spring.jdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {

	@GetMapping("/greating")
	public String hello() {
		return "helloooo.........";
	}

	@GetMapping
	public String hello1() {
		return "helloooo.........1";
	}
	



}
