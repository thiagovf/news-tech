package br.com.k19.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
 
//	@PersistenceContext(unitName = "livraria-pu")
	public static final EntityManager ENTITY_MANAGER = buildEntityManager();

    private static EntityManager buildEntityManager() {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("livraria-pu");
        EntityManager temp = factory.createEntityManager();
 
        return temp;
    }
}