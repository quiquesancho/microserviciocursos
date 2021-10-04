package edu.qui.microservicios.microserviciocursos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
		if(optionalCurso.isPresent()) {
			
			cursoAux = optionalCurso.get();
			cursoAux.setNombre(c.getNombre());
			
			cursoActualizar = cursoRepository.save(cursoAux);
			
		}
		return cursoActualizar;
	}

}
