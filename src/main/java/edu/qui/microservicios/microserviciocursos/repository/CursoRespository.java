package edu.qui.microservicios.microserviciocursos.repository;

import org.springframework.data.repository.CrudRepository;

import edu.qui.microservicios.microserviciocursos.model.entity.Curso;

public interface CursoRespository extends CrudRepository<Curso, Integer> {

}
