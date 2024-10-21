package com.todo.demotodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemotodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemotodolistApplication.class, args);
		System.out.println("server started");
	}

}
