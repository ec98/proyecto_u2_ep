package com.uce.edu.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU2EpApplication;
import com.uce.edu.demo.repository.IAutorRepository;
import com.uce.edu.demo.repository.modelo.manytomany.Autor2;

@Service
public class AutorServiceImpl implements IAutorService {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IAutorRepository iAutorRepository;

	@Override
	public void insertar(Autor2 autor) {
		// TODO Auto-generated method stub
		Logger.info("Se inserto el autor -> " + autor);
		this.iAutorRepository.insertar(autor);
	}

}
