package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.to.Estudiante;

@Repository
public class IEstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Estudiante buscar(String cedula) {
		return this.jdbcTemplate.queryForObject("select * from estudiante where cedula=?", new Object[] { cedula },
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));	}

	@Override
	public void insert(Estudiante estudiante) {
		this.jdbcTemplate.update("insert into estudiante (id, nombre, apellido, cedula, carrera) values (?,?,?,?,?)",
				new Object[] { estudiante.getId(), estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getCedula(), estudiante.getCarrera() });
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.jdbcTemplate.update("update estudiante set nombre=?, apellido=?,cedula=?,carrera=? where id=?",
				new Object[] { estudiante.getNombre(), estudiante.getApellido(), estudiante.getCedula(),
						estudiante.getCarrera(), estudiante.getId() });
	}

	@Override
	public void eliminar(String cedula) {
		this.jdbcTemplate.update("delete from estudiante where cedula=?", new Object[] { cedula });
	}

}
