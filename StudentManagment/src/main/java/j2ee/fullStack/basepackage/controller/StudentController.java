package j2ee.fullStack.basepackage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import j2ee.fullStack.basepackage.model.Student;
import j2ee.fullStack.basepackage.service.StudentService;

@RestController
@RequestMapping("/Student-Managment")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@Validated @RequestBody Student student){
		studentService.addStudent(student);
		
		return new ResponseEntity<Student>(student,new HttpHeaders(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/showAllStudents")
	public ResponseEntity<List<Student>> showAllStudents(Student student){
			
		return new ResponseEntity<List<Student>>(studentService.showAllStudents(),new HttpHeaders(),HttpStatus.OK);
	}
	
	
	
	
}
