package j2ee.fullStack.basepackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagmentApplication.class, args);
		System.out.println("---------------WELCOME TO STUDENT MANAGMENT-------------");
		
	}

}
