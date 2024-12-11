package com.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// These Is The Entry Point Of The CRM Project.The Project Structure Followes Standerd Conventions.
@SpringBootApplication(scanBasePackages = "com.app")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	

}
