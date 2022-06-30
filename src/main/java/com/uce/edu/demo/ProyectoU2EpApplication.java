package com.uce.edu.demo;

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

		Estudiante estudiante1 = new Estudiante();
		estudiante1.setId(10);
		estudiante1.setNombre("Ana");
		estudiante1.setApellido("Santanna");
		estudiante1.setCarrera("Literatura");
		estudiante1.setCedula("1282932202");

		// CREATE
		this.iEstudianteJpaService.insertar(estudiante1);
		Logger.info("Se ha creado el estudiante ->" + estudiante1);

		// READ
		Logger.info("Se ha buscado el estudiante (Date type String with JPA) -> "
				+ this.iEstudianteJpaService.buscar("1282932202"));

		// UPDATE
		Estudiante estudiante = new Estudiante();
		estudiante.setId(10);
		estudiante.setNombre("Ana");
		estudiante.setApellido("Lopez");
		estudiante.setCarrera("Comunicacion");
		estudiante.setCedula("1282932202");

		this.iEstudianteJpaService.actualizar(estudiante);
		Logger.info("Se ha actualizado el estudiante ->" + estudiante);

		// DELETE
		this.iEstudianteJpaService.eliminar("1282932202");
		Logger.info("Se ha eliminado el estudiante ->" + estudiante);

	}

}
