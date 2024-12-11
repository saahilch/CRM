package com.crm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// These Is The Entry Point Of The CRM Project.The Project Structure Followes Standerd Conventions.
@SpringBootApplication(scanBasePackages = "com.app")
public class CRM {

	public static void main(String[] args) {
		SpringApplication.run(CRM.class, args);
	}

	

}
