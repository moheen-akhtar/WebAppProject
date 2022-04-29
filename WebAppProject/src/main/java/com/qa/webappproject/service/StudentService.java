//Student DAO
//Contains //CRUD functionality methods 
package com.qa.webappproject.service;

import java.util.List;

import com.qa.webappproject.entity.Student;

public interface StudentService {

	
	Student saveStudent(Student student);
	
	List<Student> getAllStudents();
	
	Student getStudentById(long id);
	
	Student updateStudent(Student student, long id);
	
	void deleteStudent (long id); 

}
