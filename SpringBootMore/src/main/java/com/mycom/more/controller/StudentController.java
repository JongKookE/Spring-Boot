package com.mycom.more.controller;
//존잘 종국
import java.util.List;
//존잘 종국
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
//존잘 종국
import com.mycom.more.dto.StudentDto;
import com.mycom.more.service.StudentService;
//존잘 종국
@RestController
public class StudentController {
	// 존잘 종국
	@Autowired
	StudentService service;
	// 존잘 종국
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
	// 존잘 종국
	@PutMapping("/students/{studentId}")
	public int update(@PathVariable int studentId ,StudentDto dto) {
		return service.update(dto);
	}
	// 존잘 종국
	@DeleteMapping("/students/{studentId}")
	public int delete(@PathVariable int studentId) {
		return service.delete(studentId);
	}
	
	// 존잘 종국
	@GetMapping("/students/sort")
	public List<StudentDto> sort() {
		return service.sort();
	}
	
	
}
