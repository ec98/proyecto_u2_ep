package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Logger.info("List-> "+this.iPersonaJdbcService.buscarTodos());

		// BUSCAR
		Logger.info("Dato con JPA -> " + this.iPersonaJpaService.buscarporId(4));

		Persona per1 = new Persona();
		per1.setId(9);
		per1.setNombre("Maria");
		per1.setApellido("Lopez");
		
		//INSERT (GUARDAR)
		//this.iPersonaJpaService.guardar(per);
		
		//UPDATE
		//this.iPersonaJpaService.actualizar(per1);
		
		//DELETE
		this.iPersonaJpaService.eliminar(7);
	}

}
