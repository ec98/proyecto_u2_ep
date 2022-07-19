package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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
		persona.setNombre("Dayana");
		persona.setApellido("Jaramillo");
		persona.setGenero("Femenino");
		persona.setCedula("11029292022");

		// this.iPersonaJpaService.guardar(persona);

		List<PersonaSencilla> listPersonSen = this.iPersonaJpaService.buscarPorApellidoSencillo("Marco");
		for (PersonaSencilla item : listPersonSen) {
			Logger.info("(Sencillo) Persona -> " + item);
		}

		List<PersonaContadorGenero> miListPCG = this.iPersonaJpaService.consultarCantidadPorGenero();
		for (PersonaContadorGenero item : miListPCG) {
			Logger.info("Genero, Cantidad -> " + item);

		}
	}

}
