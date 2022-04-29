//Implements business logic
package com.qa.webappproject.servicebl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.qa.webappproject.Repository.StudentRepository;
import com.qa.webappproject.entity.Student;
import com.qa.webappproject.exception.ResourceNotFoundException;
import com.qa.webappproject.service.StudentService;

@Service

public class StudentServicebl implements StudentService{

	//1 constructor so don't require @autowired
	private StudentRepository studentRepository;
	
	public StudentServicebl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll(); 
	}

//Lambda 
	@Override 
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));  
	}


	@Override
	public Student updateStudent(Student student, long id) {
		
	Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
	
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setEmail(student.getEmail());
	
	return studentRepository.save(existingStudent);
	
	}


	@Override
	public void deleteStudent(long id) {
	
		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
		studentRepository.deleteById(id);
	}
	

	
}
