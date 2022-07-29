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
import com.uce.edu.demo.prueba.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba.service.IPropietarioService;
import com.uce.edu.demo.prueba.service.IVehiculoService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IMatriculaGestorService iMatriculaGestorService;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IPropietarioService iPropietarioService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Chevrolet");
		vehiculo.setPlaca("ALS-1022");
		vehiculo.setPrecio(new BigDecimal(192922));
		vehiculo.setTipo("Liviano");

		// this.iVehiculoService.insertar(vehiculo);

		Propietario propietario = new Propietario();
		propietario.setNombre("Marco");
		propietario.setApellido("Andrade");
		propietario.setCedula("1728292022");
		propietario.setFechaNacimiento(LocalDateTime.of(2001, 6, 21, 11, 5));

		// this.iPropietarioService.crear(propietario);

		//this.iMatriculaGestorService.generar(propietario.getCedula(), vehiculo.getPlaca());
	}

}
