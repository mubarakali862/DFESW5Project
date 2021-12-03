package com.qa.project.main.StudentRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.project.main.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
