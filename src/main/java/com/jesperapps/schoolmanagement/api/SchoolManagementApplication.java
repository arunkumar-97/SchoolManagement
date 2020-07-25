package com.jesperapps.schoolmanagement.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SchoolManagementApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SchoolManagementApplication.class, args);
	}

}
