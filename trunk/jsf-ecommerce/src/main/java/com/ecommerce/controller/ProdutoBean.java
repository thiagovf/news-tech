package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ecommerce.model.Produto;

@ManagedBean
@SessionScoped
public class ProdutoBean {

	private List<Produto> produtos = new ArrayList<Produto>();
	private Produto produto = new Produto();

	public void adicionaProduto() {
		this.produtos.add(produto);
		this.produto = new Produto();
		FacesMessage mensagem = new FacesMessage("Produto Adicionado!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
