package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Service layer

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
				
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentMatch = studentRepository.findStudentByEmail(student.getEmail());
		if (studentMatch.isPresent())
		{
			throw new IllegalStateException("Email already in use. Could not create new student.");
		}
		studentRepository.save(student);
		
	}

	public void deleteStudent(Long id) {
		boolean valid = studentRepository.existsById( id);
		if (!valid)
		{
			throw new IllegalStateException("Could not find and delete student with id " + id + ".");
		}
		studentRepository.deleteById( id);
		
	}


	@Transactional
	public void updateStudent(Long id, String firstName, String middleName, String lastName, String email,
			String password) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isEmpty())
		{
			throw new IllegalStateException("Could not find and update student with id " + id + ".");
		}
		Student validStudent = student.get();
		
		Optional<Student> studentMatch = studentRepository.findStudentByEmail(email);
		if (studentMatch.isPresent())
		{
			throw new IllegalStateException("Email already in use. Could not update student with id " + id +  ".");
		}
		validStudent.setFirstName(firstName);
		validStudent.setMiddleName(middleName);
		validStudent.setLastName(lastName);
		validStudent.setPassword(password);
		validStudent.setEmail(email);
		
		
		
	}

}
