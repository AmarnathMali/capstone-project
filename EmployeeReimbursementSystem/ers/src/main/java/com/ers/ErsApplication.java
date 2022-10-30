package com.ers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErsApplication.class, args);
	}

}

////Complete Flow in the application :
//############################################
//
//BROWSER -- Angular Component HTML --> Component Class --> Angular Service --> Controller layer Rest Api --> Service layer (business logic) --> Repository layer (Jdbc logic) --> database
//
//database --> repository --> service --> controller --> Angular service --> .subscribe callback function in Component class --> Component HTML --> Browser
//
//Project Architecture :
//
//Angular --> Spring Boot --> Rest Web Services --> Spring JDBC --> mysql database