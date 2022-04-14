package com.example.demo.student;


import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository testRepos;

	@Test
	void testFindStudentByEmail() {
		System.out.println("TESTING!!");
		
		boolean success = false;
		String email = "abc@uni.com";
		Student test = new Student("a", "b", "c", email, "1");
		
		System.out.println(test);
		testRepos.save(test);
		Optional<Student> match = testRepos.findStudentByEmail(email);
		
		System.out.println(match);
		if (match.isPresent())
		{
			
			success = true;
		}
		
		Assert.assertTrue(success == true);
	}

}
