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

		Persona persona = new Persona();
		persona.setNombre("Carla");
		persona.setApellido("Gomez");
		persona.setCedula("192929221");
		persona.setGenero("Femenino");

		// this.iPersonaJpaService.guardar(persona);
		
		// 1 NativeQuery
		Persona person1 = this.iPersonaJpaService.buscarporCedulaNative("192929221");
		Logger.info("(Native Query) Persona -> " + person1);

		// 2 Named Native Query
		Persona person2 = this.iPersonaJpaService.buscarporCedulaNamedNative("192929221");
		Logger.info("(Named Native Query) Persona -> " + person2);
		
		// 3 Criteria Api Query
		Persona person3 = this.iPersonaJpaService.buscarporCedulaCriteriaApi("192929221");
		Logger.info("(Criteria Api Query) Persona -> " + person3);

	}

}
