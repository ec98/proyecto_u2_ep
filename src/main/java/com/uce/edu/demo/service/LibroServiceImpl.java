package com.uce.edu.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU2EpApplication;
import com.uce.edu.demo.repository.ILibroRepository;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;

@Service
public class LibroServiceImpl implements ILibroService {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private ILibroRepository iLibroRepository;

	@Override
	public void insert(Libro2 libro) {
		// TODO Auto-generated method stub
		Logger.info("Se inserto el libro -> " + libro);
		this.iLibroRepository.insert(libro);
	}

}
