package com.Vaik.ocaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Vaik.ocaz")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
