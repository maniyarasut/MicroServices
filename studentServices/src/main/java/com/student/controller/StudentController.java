package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
@Autowired
StudentService service;
	@GetMapping
	public List<Student> getAllStudents()
	{
		return (List<Student>) service.findAll();
		
	}
	@PostMapping
	public String addStudent(@RequestBody Student student)
	{
		return service.addStudent(student);
	}
	
	@PutMapping
	public String upDateStudent(@RequestBody Student student)
	{
		return service.UpdateStudent(student);
	}

}
