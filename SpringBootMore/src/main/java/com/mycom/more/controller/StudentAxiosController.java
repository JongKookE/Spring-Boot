package com.mycom.more.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.more.dto.StudentDto;
import com.mycom.more.service.StudentService;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/axios")
public class StudentAxiosController {

	@Autowired
	StudentService service;

	@GetMapping("/students")
	public List<StudentDto> list(){
		return service.list();
	}

	@GetMapping("/students/{studentId}")
	public StudentDto detail(@PathVariable int studentId){
		return service.detail(studentId);		
	}

	@PostMapping("/students")
	public int insert(@RequestBody StudentDto dto) {
		return service.insert(dto);
	}

	@PutMapping("/students/{studentId}")
	public int update(@PathVariable int studentId , @RequestBody StudentDto dto) {
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
