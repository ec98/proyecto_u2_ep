package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.repository.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);

	public void actualizar(Vehiculo vehiculo);

	public void eliminar(String placa);

	public Vehiculo buscar(String placa);
}
