package br.com.openet.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.openet.dao.CursoDAO;
import br.com.openet.model.Curso;

@SuppressWarnings("serial")
@Named("CursoBean")
@ViewScoped
public class CursoBean implements Serializable{
	
	private Curso curso;
	private CursoDAO cursoDAO;
	
	private List<Curso> cursos;
	
	@PostConstruct
	public void init() {
		cursoDAO = new CursoDAO();
		curso = new Curso();
		
		cursos = cursoDAO.listar();
	}
	
	public void salvar() {
		cursoDAO.salvar(curso);
		
		curso = new Curso();
	}
	public void listar() {
		cursos = cursoDAO.listar();
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public CursoDAO getCursoDAO() {
		return cursoDAO;
	}

	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
