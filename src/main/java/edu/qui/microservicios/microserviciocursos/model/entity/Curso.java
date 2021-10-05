package edu.qui.microservicios.microserviciocursos.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edu.qui.microservicios.microserviciocomun.model.entity.Alumno;

@Entity
@Table(name = "cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Alumno> alumnos;
	
	public Curso() {
		this.id = 0;
		this.nombre = "";
		this.alumnos = new ArrayList<Alumno>();
	}
	
	public Curso(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
	}

	@PrePersist
	private void prePersist() {
		this.created_at = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public boolean addAlumno(Alumno a) {
		return this.alumnos.add(a);
	}
	
	public boolean removeAlumno(Alumno a) {
		return this.alumnos.remove(a);
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", created_at=" + created_at + "]";
	}
}
