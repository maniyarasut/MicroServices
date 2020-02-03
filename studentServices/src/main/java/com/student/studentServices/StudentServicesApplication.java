package com.student.studentServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableJpaRepositories("com.student.repo")
@EntityScan("com.student.model")
@ComponentScan({"com.student.model","com.student.repo","com.student.service","com.student.controller,com"})
public class StudentServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServicesApplication.class, args);
	}

}
