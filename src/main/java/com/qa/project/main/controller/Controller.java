  package com.qa.project.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qa.project.main.StudentService.StudentService;
import com.qa.project.main.model.Student;

@RestController
@RequestMapping(path = "/student")
public class Controller {
	
	private StudentService service;
	
	public Controller(StudentService service) {
		this.service = service;
	}
	List<Student> actualStudents = List.of(
			new Student(1,764784, "Tom", "Manchester"),
			new Student(2,546324, "Harry", "London")
			);

	@GetMapping
	public ResponseEntity<List<Student>> get() {
		
		//String student = "Mazda go brum";
		ResponseEntity<List<Student>> response = new ResponseEntity<List<Student>>(this.service.getAllStudents(), HttpStatus.OK);
		
		return response;
}
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
		ResponseEntity<Student> response = new ResponseEntity<Student>(this.service.updateStudent(student,  id),HttpStatus.ACCEPTED);
		return response;
}
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student Student) {
		ResponseEntity<Student> response = new ResponseEntity<Student>(this.service.createStudent(Student),HttpStatus.CREATED);	
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
		boolean deleted = this.service.deleteStudent(id);
		
		if(deleted) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
}
}
	