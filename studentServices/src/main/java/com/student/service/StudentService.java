package com.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repo.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Transactional
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> list = studentRepository.findAll();
		return list;

	}
	
	public String addStudent(Student student)
	{
		Student s1 =studentRepository.save(student);
		return s1.getName()+" inserted";
	}
	
	
	public String UpdateStudent(Student student)
	{
		Student s1 =studentRepository.getOne(student.getId());
		s1.setName(student.getName());
		s1.setEmail(student.getEmail());
		s1.setDateOfBirth(student.getDateOfBirth());
		studentRepository.save(s1);
		return s1.getName()+" inserted";
	}

}
