package com.qa.project.main.StudentService;

import java.util.List;

import com.qa.project.main.StudentRepo.StudentRepository;
import com.qa.project.main.model.Student;

public class StudentService {
	
		
		private StudentRepository repo;
		
		public StudentService(StudentRepository repo) {
			this.repo = repo;
		}
		public List<Student> getAllStudents() {
			return this.repo.findAll();
			
		}

}
