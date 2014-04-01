package br.com.k19.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class GenericDAO<T> {
	// @PersistenceContext(unitName = "livraria-pu")
	protected EntityManager entityManager;
	protected static Session session;
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	final Class<T> type;

	public GenericDAO(Class<T> typeParameterClass) {
		this.type = typeParameterClass;
		createSessionFactory();
	}

	public void createSessionFactory() {
		Configuration configuration = new Configuration();
	    configuration.configure().addAnnotatedClass(type);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
		 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		 session = sessionFactory.openSession();
	}
	
	public T getById(final Long id) {
		return entityManager.find(this.type, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria criteria = session.createCriteria(this.type);
		return criteria.list();
	}

	public void persist(T t) {
		session.saveOrUpdate(t);
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

	public void remove(T t) {
		session.delete(t);
	}

	public void removeById(final Long id) {
		try {
			T t = getById(id);
			remove(t);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
