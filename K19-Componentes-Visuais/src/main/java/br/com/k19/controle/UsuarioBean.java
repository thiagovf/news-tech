package br.com.k19.controle;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioBean {

	private int idade;
	private String nome;

	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
