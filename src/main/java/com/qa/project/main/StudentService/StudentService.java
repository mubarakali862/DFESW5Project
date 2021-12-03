package com.qa.project.main.StudentService;

import java.util.List;
import java.util.Optional;

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
		public Student updateStudent(Student student, Integer id) {
			Optional<Student> studentToFind = this.repo.findById(id);
			Student studentToUpdate = studentToFind.get();
			studentToUpdate.setRoll(student.getRoll());
		    studentToUpdate.setName(student.getName());
			studentToUpdate.setAddress(student.getAddress());
			return this.repo.save(studentToUpdate);
		}

}
