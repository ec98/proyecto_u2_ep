package com.uce.edu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private IHabitacionService iHabitacionServicel;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Hotel hotel2 = new Hotel();
//		hotel2.setNombre("Hilton Colon GYE");
//		hotel2.setDireccion("Malecon");
//		
//		this.iHotelService.insertar(hotel2);
		
		//buscar numero del hotel
		Hotel hotel = new Hotel();
		hotel.setId(1); //identifico el hotel con su respectiva habitacion
		
		Habitacion habitacion1 = new Habitacion();
		habitacion1.setNumero("A9292");
		habitacion1.setPiso("6");
		habitacion1.setTipo("Matrimonial");
		habitacion1.setHotel(hotel);
		
		Habitacion habitacion2 = new Habitacion();
		habitacion2.setNumero("A1001");
		habitacion2.setPiso("4");
		habitacion2.setTipo("Familiar");
		habitacion2.setHotel(hotel);
		
		this.iHabitacionServicel.insertar(habitacion1);
		this.iHabitacionServicel.insertar(habitacion2);
	}

}
