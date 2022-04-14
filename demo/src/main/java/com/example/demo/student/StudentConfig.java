package com.example.demo.student;



import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repos) {
		return args -> {
			Student s1 = new Student( 1L, "Mary", "Cali", "Dean",
					"mcd@uni.com", "1");
			Student s2 = new Student( "Alex", "Bryan", "Dean",
				"abd@uni.com", "1");
			Student s3 = new Student( "Nadiya", "Ann", "Wright",
					"naw@uni.com", "1");

			repos.saveAll(List.of(s1, s2, s3));
		};
		
	};
	
}

