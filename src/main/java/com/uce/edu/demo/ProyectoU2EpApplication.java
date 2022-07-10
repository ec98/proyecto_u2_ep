package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.modelo.repository.Propietario;
import com.uce.edu.demo.prueba.modelo.repository.Vehiculo;
import com.uce.edu.demo.prueba.service.IPropietarioService;
import com.uce.edu.demo.prueba.service.IVehiculoService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private IVehiculoService iVehiculoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1) CREANDO UN PROPIETARIO
		// CREATE
		Propietario propietario = new Propietario();
		propietario.setNombre("Carla");
		propietario.setApellido("Gomez");
		propietario.setCedula("1725812423"); // identificador
		propietario.setFechaNacimiento(LocalDateTime.of(1998, 9, 21, 23, 11));
		this.iPropietarioService.crear(propietario);
		Logger.info("Creando el propietario -> " + propietario);
		this.iPropietarioService.eliminar("1725812423");
		Logger.info("Eliminando propietario -> " + propietario);

		// 2) CREANDO UN VEHICULO
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Toyota");
		vehiculo.setPlaca("BED-2221");
		vehiculo.setPrecio(new BigDecimal("12933"));
		vehiculo.setTipo("Pesado");

		this.iVehiculoService.insertar(vehiculo);
		Logger.info("Creando el vehiculo -> " + vehiculo);
		Logger.info("Busanco vehiculo -> " + this.iVehiculoService.buscar("BED-2221"));
		this.iVehiculoService.eliminar("BED-2221");
		Logger.info("Eliminando el vehiculo -> " + vehiculo);

		// 3) ACTUALIZANDO 1 ATRIBUTO O 2.

		Vehiculo vehiculo1 = new Vehiculo();
		vehiculo1.setPlaca("BED-2221");
		vehiculo1.setMarca("Chevrolet");
		vehiculo1.setPrecio(new BigDecimal("1500"));
		vehiculo1.setTipo("Liviano");

		this.iVehiculoService.actualizar(vehiculo1);
		Logger.info("Actualizando el vehiculo -> " + vehiculo1);

		// 4) REALIZANDO MATRICULA
		// problema de ejecucion por la instancias de las clases.
		// this.iMatriculaGestorService.generar("1725812423", "BED-2221");
	}

}
