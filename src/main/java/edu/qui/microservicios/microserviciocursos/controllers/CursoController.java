package edu.qui.microservicios.microserviciocursos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.qui.microservicios.microserviciocomun.model.entity.Alumno;
import edu.qui.microservicios.microserviciocursos.model.entity.Curso;
import edu.qui.microservicios.microserviciocursos.services.CursoService;

@RestController
public class CursoController {

	@Autowired
	CursoService cursoService;

	@GetMapping
	public ResponseEntity<Iterable<Curso>> getCursos() {
		ResponseEntity<Iterable<Curso>> responseEntity = null;
		Iterable<Curso> cursos = null;

		cursos = cursoService.findAll();

		responseEntity = ResponseEntity.status(HttpStatus.OK).body(cursos);

		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> getCursoById(@PathVariable int id) {
		ResponseEntity<Curso> responseEntity = null;
		Optional<Curso> curso = null;

		curso = cursoService.finsById(id);

		if (curso.isPresent()) {
			responseEntity = ResponseEntity.ok(curso.get());
		} else {
			responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return responseEntity;
	}

	@PostMapping
	public ResponseEntity<Curso> addCurso(@RequestBody Curso c) {
		ResponseEntity<Curso> responseEntity = null;
		Curso newCurso = null;

		newCurso = cursoService.save(c);

		responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(newCurso);

		return responseEntity;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCurso(@PathVariable int id) {
		ResponseEntity<?> responseEntity = null;

		cursoService.deleteById(id);

		responseEntity = ResponseEntity.status(HttpStatus.OK).build();

		return responseEntity;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCurso(@PathVariable int id, @RequestBody Curso c) {
		ResponseEntity<?> responseEntity = null;
		Curso newCurso = null;

		newCurso = cursoService.update(c, id);

		if (newCurso != null) {
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(newCurso);
		} else {
			responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return responseEntity;
	}

	@PutMapping("/{id}/addAlumnos")
	public ResponseEntity<?> asignarAlumno(@RequestBody List<Alumno> alumnos, @PathVariable int id) {
		ResponseEntity<?> responseEntity = null;
		Optional<Curso> curso;

		curso = this.cursoService.addAlumnos(id, alumnos);

		if (curso.isPresent()) {
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(curso);
		} else {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return responseEntity;
	}

	@PutMapping("/{id}/deleteAlumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno a, @PathVariable int id) {
		ResponseEntity<?> responseEntity = null;
		
		Optional<Curso> curso;

		curso = this.cursoService.deleteAlumno(id, a);

		if (curso.isPresent()) {
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(curso);
		} else {
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return responseEntity;
	}

}
