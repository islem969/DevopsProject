package com.example.intershipmanagement;

import com.example.intershipmanagement.Controller.OffreController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@ComponentScan({"com.example.intershipmanagement", "com.example.intershipmanagement.Servise"})
public class IntershipManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntershipManagementApplication.class, args);
	}

}
