package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Conjunto;
import com.uce.edu.demo.service.ICasaService;
import com.uce.edu.demo.service.IConjuntoService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IConjuntoService iConjuntoService;

	@Autowired
	private ICasaService iCasaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Imprimiendo solo la tabla maestro -> "Conjunto"

		Conjunto conjunto = new Conjunto();
		conjunto.setNombre("Joel Ambart");
		conjunto.setTelefono("2929282111");
//		conjunto.setId(1);

//		Casa casa = new Casa();
//		casa.setNumero("05");
//		casa.setPisos("1");
//		casa.setCosto(new BigDecimal("2211"));
//		casa.setConjunto(conjunto);
//
//		Casa casa1 = new Casa();
//		casa1.setNumero("02");
//		casa1.setPisos("7");
//		casa1.setCosto(new BigDecimal("22323922"));
//		casa1.setConjunto(conjunto);

		// CREATE
		this.iConjuntoService.insertar(conjunto);
		// this.iCasaService.insertar(casa);
		// this.iCasaService.insertar(casa1);

		// READ
		this.iConjuntoService.buscar(7);
		// this.iCasaService.Buscar(null);

		// UPDATE
		conjunto.setNombre("San Jose Benavides");
		conjunto.setTelefono("29292929211");
		this.iConjuntoService.actualizar(conjunto);
//		 casa.setCosto(new BigDecimal("23222"));
//		 casa1.setCosto(new BigDecimal("191911"));
//		 this.iCasaService.actualizar(casa);
//		 this.iCasaService.actualizar(casa1);

		// DELETE
		this.iConjuntoService.eliminar(7);
		// this.iCasaService.eliminar(1);
	}

}
