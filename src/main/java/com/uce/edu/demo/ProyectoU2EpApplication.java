package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;
import com.uce.edu.demo.service.IAutorService;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2EpApplication implements CommandLineRunner {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IAutorService iAutorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1 libro que tiene dos autores

		Autor2 autor = new Autor2();
		autor.setNombre("Julio Jaramillo");

		Autor2 autor2 = new Autor2();
		autor2.setNombre("Andrade Marin");

		List<Autor2> listAutores = new ArrayList<Autor2>();
		listAutores.add(autor);
		listAutores.add(autor2);

		Libro2 libro = new Libro2();
		libro.setTitulo("Los 3 cerditos");
		libro.setCantidadPaginas(2011);

		libro.setAutores(listAutores);

		this.iLibroService.insert(libro);

		// 1 autor que escribio dos libros

		Autor2 autor3 = new Autor2();
		autor3.setNombre("Cantre Alman");

		Libro2 libro2 = new Libro2();
		libro2.setTitulo("Manta raya");
		libro2.setCantidadPaginas(211);

		Libro2 libro3 = new Libro2();
		libro3.setTitulo("Julieta y Romeo");
		libro3.setCantidadPaginas(2111);

		List<Libro2> listLibros = new ArrayList<Libro2>();
		listLibros.add(libro2);
		listLibros.add(libro3);

		autor3.setLibros(listLibros);

		this.iAutorService.insertar(autor3);
	}

}
