package com.mycom.more.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mycom.more.dto.StudentDto;
import com.mycom.more.service.StudentService;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("/students")
	public List<StudentDto> list(){
		return service.list();
	}
	// 존잘 종국
	@GetMapping("/students/{studentId}")
	public StudentDto detail(@PathVariable int studentId){
		return service.detail(studentId);		
	}
	// 존잘 종국
	@PostMapping("/students")
	public int insert(StudentDto dto) {
		return service.insert(dto);
	}

	@PutMapping("/students/{studentId}")
	public int update(@PathVariable int studentId ,StudentDto dto) {
		return service.update(dto);
	}

	@DeleteMapping("/students/{studentId}")
	public int delete(@PathVariable int studentId) {
		return service.delete(studentId);
	}
	

	@GetMapping("/students/sort")
	public List<StudentDto> sort() {
		return service.sort();
	}

	@PutMapping("/students/generateViews/{views}")
	public int randomViewsGenerator(@PathVariable int views){
		return service.randomViewsGenerator(views);
	}
	
	
}
