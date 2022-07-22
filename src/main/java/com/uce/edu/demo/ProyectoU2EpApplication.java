package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre("Alondra");
		ciudadano.setApellido("Uribe");
		ciudadano.setCedula("1728292922");
		ciudadano.setFechaNacimiento(LocalDateTime.of(1998, 7, 12, 23, 11, 5));

		Pasaporte pasaporte = new Pasaporte();
		pasaporte.setNumero("#0022");
		pasaporte.setFechaEmision(LocalDateTime.of(2009, 12, 1, 21, 14, 1));
		pasaporte.setFechaCaducidad(LocalDateTime.of(2017, 7, 3, 11, 10, 2));

		pasaporte.setCiudadano(ciudadano);

		ciudadano.setPasaporte(pasaporte);

//		// CREATE
		Logger.info("Se creo el ciudadano.");
		this.iCiudadanoService.insertar(ciudadano);

		// READ
		Logger.info("Se encontro el ciudadano.");
		this.iCiudadanoService.buscar(19);

		// UPDATE

		// Actualizando el ciudadano.

		ciudadano.setNombre("Paola");
		ciudadano.setApellido("Uribe");
		ciudadano.setCedula("1728292922");
		ciudadano.setFechaNacimiento(LocalDateTime.of(2001, 8, 21, 11, 1, 3));
		
		Logger.info("Actualizando ciudadano.");
		this.iCiudadanoService.actualizar(ciudadano);

		// DELETE
		Logger.info("Se elimino el ciudadano.");
		this.iCiudadanoService.eliminar(19);
	}

}
