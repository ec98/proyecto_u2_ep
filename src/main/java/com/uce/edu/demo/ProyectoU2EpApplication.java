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

		// READ
		List<Persona> listaPersonG = this.iPersonaJpaService.buscarporGenero("M");

		for (Persona per : listaPersonG) {
			Logger.info("Genero -> " + per);
		}

		List<Persona> listaPersonN = this.iPersonaJpaService.buscarporNombre("Ana");
		for (Persona per2 : listaPersonN) {
			Logger.info("Nombre -> " + per2);
		}
	}

}
