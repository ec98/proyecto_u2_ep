package com.uce.edu.demo;

import java.util.List;

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
		// persona.setId(10);
		persona.setNombre("Ana");
		persona.setApellido("Santanna");
		persona.setGenero("M");
		persona.setCedula("1224242221");

		// CREATE
		// this.iPersonaJpaService.guardar(persona);
		// Logger.info("Se ha creado el estudiante ->" + persona);

		//READ
		Persona p = this.iPersonaJpaService.buscarporCedula("1224242221");
		Logger.info("Persona encontrada -> " + p);
		
		List<Persona> listaPersonas = this.iPersonaJpaService.buscarporApellido("Santanna");
		
		for(Persona per: listaPersonas) {
			Logger.info("Persona -> "+per);
		}
		
	}

}
