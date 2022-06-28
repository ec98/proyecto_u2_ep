package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.to.Estudiante;
import com.uce.edu.demo.service.IEstudianteJdbcService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IEstudianteJdbcService iEstudianteJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estudiante estudiante = new Estudiante();

		estudiante.setId(3);
		estudiante.setNombre("Juan");
		estudiante.setApellido("Perez");
		estudiante.setCedula("1231311111");
		estudiante.setCarrera("Matematica");

		// INSERT
		this.iEstudianteJdbcService.insert(estudiante);
		Logger.info("Se inserta el estudiante-> " + estudiante);

		// UPDATE
		Estudiante estudiante1 = new Estudiante();
		estudiante1.setId(3);
		estudiante1.setNombre("Juan");
		estudiante1.setApellido("Pereza");
		estudiante1.setCedula("1492929222");
		estudiante1.setCarrera("Educacion");

		this.iEstudianteJdbcService.actualizar(estudiante1);
		Logger.info("Se actualiza el estudiante-> " + estudiante1);

		// DELETE
		this.iEstudianteJdbcService.eliminar("1492929222");
		Logger.info("Se elimina el estudiante-> "+estudiante1);

		// SELECT
		Logger.info("Se busca el estudiante -> "+this.iEstudianteJdbcService.buscar("183829221"));
	}

}
