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

		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Mario");
		estudiante.setApellido("Encalada");
		estudiante.setCarrera("Odontologia");
		estudiante.setCedula("1929221122"); // identificador

		// this.iEstudianteJpaService.insertar(estudiante);

		// 1) Native Query
		Estudiante estu = this.iEstudianteJpaService.buscarPorCedulaNative("1929221122");
		Logger.info("(Native Query) Estudiante -> " + estu);

		List<Estudiante> ListEstudiante1 = this.iEstudianteJpaService.buscarPorNombreApellidoCarreraNative("Mario",
				"Encalada", "Odontologia");
		for (Estudiante item : ListEstudiante1) {
			Logger.info("(Native Query) Estudiante -> " + item);
		}

		// 2) NamedNative Query
		List<Estudiante> listEstudiante2 = this.iEstudianteJpaService.buscarPorApellidoCarreraNamedNative("Gomez",
				"Odontologia");
		for (Estudiante item : listEstudiante2) {
			Logger.info("(NamedNative Query) Estudiante -> " + item);
		}

		int result = this.iEstudianteJpaService.eliminarNombreApellidoCarreraCedulaNamedNative("Favian", "Gomez",
				"Odontologia", "192921919101");
		Logger.info("(NamedNative Query) Eliminado estudiante -> " + result);

	}

}
