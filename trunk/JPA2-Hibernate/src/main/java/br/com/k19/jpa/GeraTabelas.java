package br.com.k19.jpa;

import java.util.ArrayList;
import java.util.List;


public class GeraTabelas {
	public static void main(String[] args) {
		EditoraDAO editoraDAO = new EditoraDAO();

		Editora editora = new Editora();
		editora.setEmail("editora@test.co.uk");
		editora.setNome("editora01");

		LivroDAO livroDAO = new LivroDAO();
		Livro livro1 = new Livro();
		livro1.setEditora(editora);
		livro1.setTitulo("The Lord of The Rings");

		List<Livro> livros = new ArrayList<Livro>();
		livros.add(livro1);
		editora.setLivros(livros);

		editoraDAO.persist(editora);
		livroDAO.persist(livro1);
		
		
		List<Editora> list = editoraDAO.findAll();
		for (Editora ed : list) {
			System.out.println(ed.getEmail());
		}
	}
}
