package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IFacturaService iFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Factura fact = this.iFacturaService.consultar(1);
		Logger.info("Numero -> " + fact.getNumero());
		Logger.info("Fecha -> " + fact.getFecha());
		Logger.info("Cliente -> " + fact.getCliente().getNumeroTarjeta());

		List<DetalleFactura> detallefactura = fact.getDetallefactura();
		for (DetalleFactura deta : detallefactura) {
			Logger.info("Detalles -> " + deta);
		}
	}

}
