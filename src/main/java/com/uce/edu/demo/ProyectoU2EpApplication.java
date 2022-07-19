package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
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
		estudiante.setNombre("Marcus");
		estudiante.setApellido("Sebastian");
		estudiante.setCarrera("Odontologia");
		estudiante.setCedula("1485839222");

		// this.iEstudianteJpaService.insertar(estudiante);

		// Objetos Sencillos

		// Ejemplo 1
		List<EstudianteSencillo> listEs = this.iEstudianteJpaService.buscarPorApellidoCarreraCedulaSencillo("Gomez");
		for (EstudianteSencillo item : listEs) {
			Logger.info("(Objeto Sencillo) -> " + item);
		}
		
		//Ejemplo 2
		List<EstudianteContadorCarrera> listECC = this.iEstudianteJpaService.contadorGeneralCarrera();
		for (EstudianteContadorCarrera item : listECC) {
			Logger.info("(Carrera, Apellido, Nombre) -> " + item);
		}
	}

}
