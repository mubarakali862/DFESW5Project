package com.qa.project.main.StudentService;

import com.qa.project.main.StudentRepo.StudentRepository;

public class StudentService {
	
		
		private StudentRepository repo;
		
		public StudentService(StudentRepository repo) {
			this.repo = repo;
		}

}
