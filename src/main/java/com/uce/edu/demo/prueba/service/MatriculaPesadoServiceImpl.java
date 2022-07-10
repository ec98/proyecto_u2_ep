package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Qualifier(value="pesado")
public class MatriculaPesadoServiceImpl implements IMatriculaService{

	@Override
	public BigDecimal calcular(BigDecimal precio) {
		// TODO Auto-generated method stub
		return precio.multiply(new BigDecimal(0.10));
	}

}
