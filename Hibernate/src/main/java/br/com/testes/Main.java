package br.com.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hello");
        EntityManager em = emf.createEntityManager();
 
        try {
            em.getTransaction().begin();
             
            User user = new User();
            user.setName("abc123");
            user.setPassword("abc123");
             
            em.persist(user);
             
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
         
        System.out.println("It is over");
	}
}
