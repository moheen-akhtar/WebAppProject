//Handles incoming requests, directs them to the appropriate service and returns responses
package com.qa.webappproject.controller;

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

import com.qa.webappproject.entity.Student;
import com.qa.webappproject.service.StudentService;

////Will handle Web API request
@RestController
@RequestMapping("/show/students")
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//Create student
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	
	
	
		
	
	
	
	
	//Get all students. GET requests
	@GetMapping(path = "/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	//Get student by ID
	// E.g. http://localhost:8080/show/students/1 
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId) {
		return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
		
	}
	
	//Update student byID
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
		
	}
	
	//Delete student by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Successfully deleted student", HttpStatus.OK);
	}
	
	
	
}

