package br.com.k19.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EditoraDAO {

	protected EntityManager entityManager;
	public EditoraDAO() {
		entityManager = HibernateUtil.ENTITY_MANAGER;
	}
	
	public Editora getById(final Long id) {
        return entityManager.find(Editora.class, id);
    }
 
    public List<Editora> findAll() {
    	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    	CriteriaQuery<Editora> cq = builder.createQuery(Editora.class);
    	Root<Editora> rootEntry = cq.from(Editora.class);
        CriteriaQuery<Editora> all = cq.select(rootEntry);
        TypedQuery<Editora> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
 
    public void persist(Editora editora) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(editora);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void merge(Editora editora) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(editora);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void remove(Editora editora) {
        try {
            entityManager.getTransaction().begin();
            editora = entityManager.find(Editora.class, editora.getId());
            entityManager.remove(editora);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    public void removeById(final Long id) {
        try {
        	Editora editora = getById(id);
            remove(editora);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
