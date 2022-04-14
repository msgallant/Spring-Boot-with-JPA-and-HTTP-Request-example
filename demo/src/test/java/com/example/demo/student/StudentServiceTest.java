package com.example.demo.student;

import static org.mockito.Mockito.verify;


import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class StudentServiceTest {
	
	@Mock
	private StudentRepository testRepos;
	
	private AutoCloseable closable;
	
	private StudentService testService;
	
	@BeforeEach
	void setUp() {
		closable = MockitoAnnotations.openMocks(this);
		testService = new StudentService(testRepos);
	}

	@AfterEach
	void tearDown() throws Exception {
		closable.close();
	}
	
	@Test
	void testGetStudents() {
		testService.getStudents();
		//getStudents() should findAll()
		verify(testRepos).findAll();
	}

	@Test
	void testAddNewStudent() {
		Student s = new Student( "Nadiya", "Ann", "Wright",
				"naw@uni.com", "1");
		
		testService.addNewStudent(s);
		
		//capture the student that was passed in to addNewStudent(s) is the same one that gets saved by the repository
		ArgumentCaptor<Student> studentArgCaptor = 
				ArgumentCaptor.forClass(Student.class);

		verify(testRepos).save(studentArgCaptor.capture());
		
		Student captured = studentArgCaptor.getValue();
		
		
		Assert.assertTrue(captured.equals(s));
		
	}


}
