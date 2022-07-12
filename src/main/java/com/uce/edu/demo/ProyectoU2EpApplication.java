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
		persona.setNombre("Edwin");
		persona.setApellido("Piruch");
		persona.setCedula("1202939222");
		persona.setGenero("Masculino");

		this.iPersonaJpaService.guardar(persona);

		// 1 TypedQuery
		Persona perTyped = this.iPersonaJpaService.buscarporCedulaTyped("1725860553");
		Logger.info("Persona Typed -> " + perTyped);
		// 2 NamedQuery
		Persona perNamed = this.iPersonaJpaService.buscarporCedulaNamed("1725860553");
		Logger.info("Persona Named -> " + perNamed);

		// 3 TypedNamedQuery
		Persona TypedNamed = this.iPersonaJpaService.buscarporCedulaTypedNamed("1725860553");
		Logger.info("Persona TypedNamed -> " + TypedNamed);

		// 4 Varios NamedQuery
		List<Persona> listaPersona = this.iPersonaJpaService.buscarporNombreApellido("Edwin", "Piruch");
		for (Persona item : listaPersona) {
			Logger.info("Persona -> " + item);
		}
	}

}
