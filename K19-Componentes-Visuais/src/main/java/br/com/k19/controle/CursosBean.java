package br.com.k19.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.k19.model.Curso;

@ManagedBean
@SessionScoped
public class CursosBean {
	private List<Curso> cursos = new ArrayList<Curso>();
	private Curso curso = new Curso();
	
	public void adicionaCurso() {
		this.cursos.add(this.curso);
		this.curso = new Curso();
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
