package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.ecommerce.model.FaleConosco;

@ManagedBean
public class FaleConoscoBean {

	private List<String> assuntos;

	private FaleConosco fale;

	public FaleConoscoBean() {
		fale = new FaleConosco();
		assuntos = new ArrayList<String>();
		assuntos.add("Particular");
		assuntos.add("Público");
		assuntos.add("Algo importante");
	}

	public List<String> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<String> assuntos) {
		this.assuntos = assuntos;
	}

	public FaleConosco getFale() {
		return fale;
	}

	public void setFale(FaleConosco fale) {
		this.fale = fale;
	}

}
