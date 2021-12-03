import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student Student) {
		ResponseEntity<Student> response = new ResponseEntity<Student>(this.service.createStudent(Student),HttpStatus.CREATED);	
		return response;
	}
}
