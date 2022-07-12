package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Persona;
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

		Estudiante estudiante = new Estudiante();
		// estudiante.setId(?) no usamos porque no es un identificador para estudiante.
		estudiante.setNombre("Favian");
		estudiante.setApellido("Gomez");
		estudiante.setCedula("19292029191"); // identificador
		estudiante.setCarrera("Matematicas");

		// this.iEstudianteJpaService.insertar(estudiante);

		// 1) TypedQuery

		Estudiante esttudiante1 = this.iEstudianteJpaService.buscarPorCedulaTyped("1229292211");
		Logger.info(" (TypedQuery) Estudiante -> " + esttudiante1);

		List<Estudiante> listaEstudiante1 = this.iEstudianteJpaService.buscarPorNombreApellidoTyped("Favian", "Gomez");
		for (Estudiante item : listaEstudiante1) {
			Logger.info(" (TypedQuery) Estudiante -> " + item);
		}

		// 2) NamedQuery

		Estudiante estudiante2 = this.iEstudianteJpaService.buscarPorCedulaNamed("19292029191");
		Logger.info(" (NamedQuery) Estudiante -> " + estudiante2);

		List<Estudiante> listaEstudiante2 = this.iEstudianteJpaService.buscarPorNombreApellidoNamed("Carla", "Gomez");
		for (Estudiante item : listaEstudiante2) {
			Logger.info(" (NamedQuery) Estudiante -> " + item);
		}

		// 3) TypedQuery ^ NamedQuery
		Estudiante estudiante3 = this.iEstudianteJpaService.buscarPorCedulaTypedNamed("1229292211");
		Logger.info("(TypedQuery AND NamedQuery) Estudiante -> " + estudiante3);

		List<Estudiante> listaEstudiante3 = this.iEstudianteJpaService.buscarPorNombreApellidoTypedNamed("Edwin",
				"Piruch");
		for (Estudiante item : listaEstudiante3) {
			Logger.info(" (TypedQuery AND NamedQuery) Estudiante -> " + item);
		}

	}

}
