package edu.qui.microservicios.microserviciocursos.services;

import java.util.List;
import java.util.Optional;

import edu.qui.microservicios.microserviciocomun.model.entity.Alumno;
import edu.qui.microservicios.microserviciocursos.model.entity.Curso;

public interface CursoService {
	
	public Iterable<Curso> findAll();
	
	public Optional<Curso> finsById(int id);
	
	public Curso save(Curso c);
	
	public void deleteById(int id);
	
	public Curso update(Curso c, int id);
	
	public Optional<Curso> addAlumnos(int id, List<Alumno> a);
	
	public Optional<Curso> deleteAlumno(int id, Alumno a);

}
