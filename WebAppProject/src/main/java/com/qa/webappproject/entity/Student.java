package com.qa.webappproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotBlank(message = "Value cannot be null or whitespace") 
	@Size(min = 2, max = 16, message = "Student must have atleast 2 characters, but no more than 16")
	@Column(name = "first_name") 
	private String firstName;
	
	@NotBlank(message = "Value cannot be null or whitespace") 
	@Size(min = 2, max = 16, message = "Student must have atleast 2 characters, but no more than 16")
	@Column(name = "last_name") 
	private String lastName;
	
	@NotNull
	@Email
	@Column(name = "email")
	private String email;

	@OneToOne(mappedBy = "student",
			 optional = false,
			 cascade = {CascadeType.ALL},
			 targetEntity = StudentProfile.class,
			 fetch = FetchType.EAGER)
		
	private StudentProfile studentProfile;
			
	
			
	public Student() {
		super();
	}

	public Student(long id,
			@NotBlank(message = "Value cannot be null or whitespace") @Size(min = 2, max = 16, message = "Student must have atleast 2 characters, but no more than 16") String firstName,
			@NotBlank(message = "Value cannot be null or whitespace") @Size(min = 2, max = 16, message = "Student must have atleast 2 characters, but no more than 16") String lastName,
			@NotNull @Email String email, StudentProfile studentProfile) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.studentProfile = studentProfile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	}
	
	
	