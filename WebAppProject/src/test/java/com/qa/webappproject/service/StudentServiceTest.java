package com.qa.webappproject.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.qa.webappproject.entity.Student;
import com.qa.webappproject.servicebl.StudentServicebl;

class StudentServiceTest {
	
	private DriverManagerDataSource dataSource;
	private StudentService dao;
	
	
	@Test
	void testSaveStudent() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver"); 
		dataSource.setUrl("jdbc:mysql://localhost:3306/sms");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dao = new StudentServicebl(dataSource);
		Student student = new Student();
		
	}

	@Test
	void testGetAllStudents() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStudentById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateStudent() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteStudent() {
		fail("Not yet implemented");
	}

}
