package com.uce.edu.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU2EpApplication;
import com.uce.edu.demo.repository.ICasaRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Casa;

@Service
public class CasaServiceImpl implements ICasaService {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private ICasaRepository iCasaRepository;

	@Override
	public void insertar(Casa casas) {
		// TODO Auto-generated method stub
		Logger.info("Insertando casa -> " + casas);
		this.iCasaRepository.insertar(casas);
	}

	@Override
	public void actualizar(Casa casas) {
		// TODO Auto-generated method stub
		Logger.info("Actualizando casa -> " + casas);
		this.iCasaRepository.actualizar(casas);
	}

	@Override
	public Casa Buscar(Integer id) {
		// TODO Auto-generated method stub
		Logger.info("Buscando casa -> " + id);
		return this.iCasaRepository.Buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Logger.info("Eliminando casa -> " + id);
		this.iCasaRepository.eliminar(id);
	}

}
