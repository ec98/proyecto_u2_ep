package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Criteria Api (2 ejemplos de la entidad Estudiante)

		// Ejemplo 1
		List<Estudiante> mylistEstudiante = this.iEstudianteJpaService.buscarPorNombreApellidoCriteriaApi("Favian",
				"Gomez");
		for (Estudiante item : mylistEstudiante) {
			Logger.info("(Criteria Api) Estudiante-> " + item);
		}

		// Ejemplo 2
		Estudiante estudiante = this.iEstudianteJpaService.buscarPorCedulaCarreraCriteriaApi("12292111111",
				"Computacion");
		Logger.info("(Criteria Api) Estudiante -> " + estudiante);
	}

}
