package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.to.EstudianteTo;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EstudianteTo buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select * from estudiante where cedula=?", new Object[] { cedula },
				new BeanPropertyRowMapper<EstudianteTo>(EstudianteTo.class));
	}

	@Override
	public void insertar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into estudiante (id,nombre,apellido,cedula,carrera) values (?,?,?,?,?)",
				new Object[] { estudiante.getId(), estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getCedula(), estudiante.getCarrera() });
	}

	@Override
	public void actualizar(EstudianteTo estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set nombre=?, apellido=?,cedula=?,carrera=? where id=?",
				new Object[] { estudiante.getNombre(), estudiante.getApellido(), estudiante.getCedula(),
						estudiante.getCarrera(), estudiante.getId() });
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from estudiante where cedula=?", new Object[] { cedula });
	}

}
