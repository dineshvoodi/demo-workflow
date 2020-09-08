package com.example.workflow.demoworkflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class DemoWorkflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWorkflowApplication.class, args);
	}

}
