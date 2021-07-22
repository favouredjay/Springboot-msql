package com.schoolfilemanagementsystem.schoolfilemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileManagementSystemApplication.class, args);
		System.out.println("Server started!");
	}

}
