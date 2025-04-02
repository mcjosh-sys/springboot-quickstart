package com.mcjosh.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(QuickstartApplication.class);
		SpringApplication.run(QuickstartApplication.class, args);
		app.setDefaultProperties(Map.of("server.port","8800"));
		app.run(args);
	}

}
