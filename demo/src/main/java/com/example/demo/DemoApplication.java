package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.HttpRequestClient;
import com.example.demo.student.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

@SpringBootApplication
@RestController
public class DemoApplication {
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		
		
		askForCommand();
	      
	     
		
	}
	
	protected static void askForCommand() throws Exception {
		String newStudentCommand = "new student";
		String fetchStudentsCommand = "fetch students";
		String deleteStudentCommand = "delete student";
		String updateStudentCommand = "update student";
		System.out.println("Commands available: \n '" + newStudentCommand + "' without quotes to create a new student, \n '"
				 + fetchStudentsCommand + "' to view students in database, \n '" + deleteStudentCommand + "' "
				 + "to delete a student in database, \n '" + updateStudentCommand + "' to update a student entry. \n"
				 );
		BufferedReader reader =
	                new BufferedReader(new InputStreamReader(System.in));
	     String commandName = reader.readLine();
	     
	     if (commandName.equals(newStudentCommand))
	     {
	    	 createNewStudent();
	     }
	     else if (commandName.equals(fetchStudentsCommand))
	     {
	    	 fetchStudents();
	     }
	     else if (commandName.equals(deleteStudentCommand))
	     {
	    	 deleteStudent();
	     }
	     else if (commandName.equals(updateStudentCommand))
	     {
	    	 updateStudent();
	     }
	     else {
	    	 System.out.println("Command not found.");
	     }
	     System.out.println("Ready for a new command.");
	     askForCommand();
	     
	}
	
	protected static void updateStudent() throws Exception {
		HttpRequestClient req = new HttpRequestClient();
		Scanner scanner = new Scanner(System.in);
		String[] data = new String[5];

		Long id = (long) getUserInput("Input id of student you wish to update: ", scanner);
		
		BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
		
		data[0] = getUserInput("Input first name of student with id: " + String.valueOf(id) + "\n", reader);
		data[1] = getUserInput("Input middle name of student with id: " + String.valueOf(id) + "\n", reader);
		data[2] = getUserInput("Input last name of student with id: " + String.valueOf(id) + "\n", reader);
		data[3] = getUserInput("Input email of student with id: " + String.valueOf(id)+ "\n", reader);
		data[4] = getUserInput("Input password of student with id: " + String.valueOf(id)+ "\n", reader);
		
		Student s = new Student(id, data[0], data[1], data[2],
				data[3], data[4]);
		req.sendPut(s);
	}
	
	protected static void deleteStudent() throws Exception {
		HttpRequestClient req = new HttpRequestClient();
		
		Scanner scanner = new Scanner(System.in);

		int id = getUserInput("Input id of student you wish to delete: ", scanner);
		req.sendDelete(id);
	}
	protected static void fetchStudents() throws Exception {
		HttpRequestClient req = new HttpRequestClient();
		req.sendGet();
	}
	
	protected static boolean createNewStudent() throws Exception {
		System.out.println("Creating new student...");
		
		String[] instructions = {"input student first name: ", "input student middle name: ",
				"input student last name: ", "input student email: ", "input student password: "};
		String[] data = new String[5];
		BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

		data[0] = getUserInput(instructions[0], reader);
		data[1] = getUserInput(instructions[1], reader);
		data[2] = getUserInput(instructions[2], reader);
		data[3] = getUserInput(instructions[3], reader);
		data[4] = getUserInput(instructions[4], reader);
		
		
	
		Student s = new Student( data[0], data[1], data[2],
				data[3], data[4]);
		
		HttpRequestClient req = new HttpRequestClient();
		req.sendPost(s);
		
		return true;
		
	}
	
	protected static String getUserInput( String instruction, BufferedReader reader) throws Exception {
		System.out.println(instruction);
		String info = reader.readLine();
		return info;
	}
	
	protected static int getUserInput( String instruction, Scanner scanner) throws Exception {
		System.out.println(instruction);
		int num = -1;
		if (scanner.hasNextInt())
		{
			num = scanner.nextInt();
		}
		return num;
	}
	

	
}
