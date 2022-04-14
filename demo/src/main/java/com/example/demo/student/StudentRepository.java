package com.example.demo.student;
//import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//responsible for data access
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{


	//SELECT * FROM student WHERE email = (string email we pass in)
	//Student is our Student class
	//@Query("SELECT s1 FROM Student s1 WHERE s1.email = ?1")
	Optional<Student> findStudentByEmail(String email);
}
