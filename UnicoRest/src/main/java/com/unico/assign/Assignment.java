package com.unico.assign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Assignment{
	
	public static void main(String[] args) {
		SpringApplication.run(Assignment.class, args);
	}

}
