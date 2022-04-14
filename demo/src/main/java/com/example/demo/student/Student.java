package com.example.demo.student;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
			)
	
	
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	//private String coursesRegisteredIn; //REMOVE
	//private String transcript;
	
	public Student() {
		super();
	}

	public Student(Long id, String firstName, String middleName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		//this.coursesRegisteredIn = new ArrayList<String>();
		//this.transcript = new ArrayList<String>();
	}
	public Student(String firstName, String middleName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		//this.coursesRegisteredIn = new ArrayList<String>();
		//this.transcript = new ArrayList<String>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Student [ id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + " ]"; //+ ", coursesRegisteredIn="
				//+ coursesRegisteredIn + ", transcript=" + transcript + " ]";
	}
	

	
}
