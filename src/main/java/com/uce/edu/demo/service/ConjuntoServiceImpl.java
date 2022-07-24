package com.uce.edu.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.ProyectoU2EpApplication;
import com.uce.edu.demo.repository.IConjuntoRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Conjunto;

@Service
public class ConjuntoServiceImpl implements IConjuntoService {

	private static final Logger Logger = LoggerFactory.getLogger(ProyectoU2EpApplication.class);

	@Autowired
	private IConjuntoRepository iConjuntoRepository;

	@Override
	public void insertar(Conjunto conjunto) {
		// TODO Auto-generated method stub
		Logger.info("Conjunto -> " + conjunto);
		this.iConjuntoRepository.insertar(conjunto);
	}

	@Override
	public void actualizar(Conjunto conjunto) {
		// TODO Auto-generated method stub
		Logger.info("Actualizando el conjunto -> " + conjunto);
		this.iConjuntoRepository.actualizar(conjunto);
	}

	@Override
	public Conjunto buscar(Integer id) {
		// TODO Auto-generated method stub
		Logger.info("Id del conjunto -> " + id);
		return this.iConjuntoRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Logger.info("Conjunto eliminado -> " + id);
		this.iConjuntoRepository.eliminar(id);
	}

}
