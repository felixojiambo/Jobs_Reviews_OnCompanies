package com.zep.JobApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobApplication {

	public static void main(String[] args) {

		SpringApplication.run(JobApplication.class, args);
		System.out.print("server running on default tomcat port");
	}

}
