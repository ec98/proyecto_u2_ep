package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//1) Criteria API
		
		Persona perTyped = this.iPersonaJpaService.buscarporCedulaCriteriaApi("192929221");
		Logger.info("(Criteria API) Persona -> " + perTyped);

		Persona perDinamico = this.iPersonaJpaService.buscarDinamicamente("Carla", "Chavez", "Femenino");
		Logger.info("(Dinamico) Persona -> " + perDinamico);
	}

}
