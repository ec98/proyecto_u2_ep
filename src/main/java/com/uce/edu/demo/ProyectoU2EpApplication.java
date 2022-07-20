package com.uce.edu.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
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

		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Maria");
		ciu1.setApellido("Lopez");
		
		Empleado emp1 = new Empleado();
		emp1.setCodigoIess("12292");
		emp1.setSalario(new BigDecimal(45042));
		//sentenciar el tipo de dato, si comento el empl_id_ciudadno sera null
		emp1.setCiudadano(ciu1);
		
		ciu1.setEmpleado(emp1);
		
		this.iCiudadanoService.insertar(ciu1);
		
		//---------------------------------------
		
		Ciudadano ciu2 = new Ciudadano();
		ciu2.setNombre("Maria");
		ciu2.setApellido("Lopez");
		
		Empleado emp2 = new Empleado();
		emp2.setCodigoIess("12292");
		emp2.setSalario(new BigDecimal(45042));
		emp2.setCiudadano(ciu2);
		
		ciu2.setEmpleado(emp2);
		//this.iCiudadanoService.insertar(emp2);

	}

}
