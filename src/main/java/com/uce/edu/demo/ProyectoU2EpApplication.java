package com.uce.edu.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//imports logs
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner{

	public static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Logger.info("Funciando log4j [HOLA MUNDO]");
	}

}
