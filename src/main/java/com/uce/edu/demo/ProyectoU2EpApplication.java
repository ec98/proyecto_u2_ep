package com.uce.edu.demo;

//imports logs
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.to.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// no es tecnico realizar el sysout.
		// System.out.println("HOLA MUNDO");

		// estos son niveles
		// Logger.info("Funciando log4j [HOLA MUNDO]");
		// Logger.error("Error el estudiante no existe");
		// este nivel se utiliza para consultar para saber que esta pasando
		// Logger.debug(""); //nivel debug: debe ser relacionado al termino.

		Persona person = new Persona();
		person.setId(4);
		person.setNombre("Edwin");
		person.setApellido("Piruch");
		
		//INSERT
		//this.iPersonaJdbcService.guardar(person);
		
		//UPDATE
		//puedes actualizar la misma persona pero siempre y cuando no sea una lista.
		//this.iPersonaJdbcService.actualizar(person);
		
		//DELETE
		//no afecta a los otros parametros de apellido y nombre, con el identificador basta
		//this.iPersonaJdbcService.eliminar(1);
		
		//SELECT
		Logger.info("Retorna el id -> "+this.iPersonaJdbcService.buscarporId(3));
		//buscando la persona por los atributos del constructor class.
		Logger.info("Retorna la persona -> "+person);

	}

}
