package br.com.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="teste")
public class TesteBean {

	private int numero;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		System.out.println(" YAHOO! -_- " + numero);
		this.numero = numero;
	}

	public void incrementaNumero() {
		System.out.println(" Numero :: " + this.numero);
		this.numero++;
	}

}
