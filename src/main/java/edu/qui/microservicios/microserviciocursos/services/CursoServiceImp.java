package edu.qui.microservicios.microserviciocursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.qui.microservicios.microserviciocomun.model.entity.Alumno;
import edu.qui.microservicios.microserviciocursos.model.entity.Curso;
import edu.qui.microservicios.microserviciocursos.repository.CursoRespository;

@Service
public class CursoServiceImp implements CursoService {

	@Autowired
	CursoRespository cursoRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Curso> findAll() {
		Iterable<Curso> cursos = null;

		cursos = cursoRepository.findAll();

		return cursos;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Curso> finsById(int id) {
		Optional<Curso> curso = null;

		curso = cursoRepository.findById(id);
		return curso;
	}

	@Override
	@Transactional
	public Curso save(Curso c) {
		Curso cursoNuevo = null;

		cursoNuevo = cursoRepository.save(c);

		return cursoNuevo;
	}

	@Override
	@Transactional
	public void deleteById(int id) {

		cursoRepository.deleteById(id);

	}

	@Override
	@Transactional
	public Curso update(Curso c, int id) {
		Optional<Curso> optionalCurso = null;
		Curso cursoActualizar = null;
		Curso cursoAux;

		optionalCurso = cursoRepository.findById(id);

		if (optionalCurso.isPresent()) {

			cursoAux = optionalCurso.get();
			cursoAux.setNombre(c.getNombre());

			cursoActualizar = cursoRepository.save(cursoAux);

		}
		return cursoActualizar;
	}

	@Override
	@Transactional
	public Optional<Curso> addAlumnos(int id, List<Alumno> a) {
		Optional<Curso> optional = null;
		Curso cursoAux;
		Curso cursoActu;

		optional = this.cursoRepository.findById(id);

		if (optional.isPresent()) {
			cursoAux = optional.get();

			a.forEach(alumno -> {
				cursoAux.addAlumno(alumno);
			});

			cursoActu = this.cursoRepository.save(cursoAux);

			optional = Optional.of(cursoActu);
		}

		return optional;
	}

	@Override
	public Optional<Curso> deleteAlumno(int id, Alumno a) {
		Optional<Curso> optional;
		Curso cursoAux;
		Curso cursoActu;

		optional = this.cursoRepository.findById(id);

		if (optional.isPresent()) {
			cursoAux = optional.get();

			cursoAux.removeAlumno(a);

			cursoActu = this.cursoRepository.save(cursoAux);

			optional = Optional.of(cursoActu);
		}

		return optional;
	}

}
