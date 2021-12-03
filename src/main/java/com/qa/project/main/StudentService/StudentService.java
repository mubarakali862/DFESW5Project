package com.qa.project.main.StudentService;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.qa.project.main.StudentRepo.StudentRepository;
import com.qa.project.main.model.Student;
@Service
public class StudentService {
	
	private StudentRepository repo;
	
	public StudentService(StudentRepository repo) {
		this.repo = repo;
	}
	
	public List<Student> getAllStudents() {
		return this.repo.findAll();
		
	}
	
	public Student getbyID(Integer id) {
		Optional<Student> studentToFind = this.repo.findById(id);
		Student foundStudent = studentToFind.get();
		return foundStudent;
		
	}
	
	public Student updateStudent(Student student, Integer id) {
		Optional<Student> studentToFind = this.repo.findById(id);
		Student studentToUpdate = studentToFind.get();
		studentToUpdate.setRoll(student.getRoll());
	    studentToUpdate.setName(student.getName());
		studentToUpdate.setAddress(student.getAddress());
		return this.repo.save(studentToUpdate);
	}
	
	public Student createStudent(Student student) {
		return this.repo.save(student);
	}
	
	public boolean deleteStudent(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
}
