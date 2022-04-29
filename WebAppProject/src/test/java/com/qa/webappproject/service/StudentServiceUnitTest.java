package com.qa.webappproject.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.webappproject.Repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceUnitTest {

	@Mock
	private StudentRepository studentRepository; 
	
	@InjectMocks
	private StudentService studentService; 
	
	
	
	@Test
	public void getAllTest() {
		
	}
	@Test
	public void getByIdTest() {
		
	}
	@Test
	public void getByInvalidIdTest() {
		int id = 328888293;
		when(studentRepository.findById((long) id)).thenReturn(Optional.empty());
	
	EntityNotFoundException exception = Assertions.assertThrows(EntityNotFoundException.class, () -> {
		studentService.getStudentById(id);
	});
		
	String expectedMessage = "Student not found with id " + id;
	assertequals(expectedMessage, exception.getMessage());
	verify(studentRepository).findById((long) id);
	
	}
		
	

	private void assertequals(String expectedMessage, String message) {
		// TODO Auto-generated method stub
		
	}



	
	
	@Test
	public void createTest() {
		
	}
}
