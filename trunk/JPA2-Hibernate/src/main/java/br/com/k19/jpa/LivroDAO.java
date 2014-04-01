package br.com.k19.jpa;

import javax.persistence.EntityManager;

public class LivroDAO {

	protected EntityManager entityManager;
	public LivroDAO() {
		entityManager = HibernateUtil.ENTITY_MANAGER;
	}
	
	public void persist(Livro livro) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
