package br.com.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonDetail {
	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) {
		Session session = null;
		try {
			PersonFactory factory = new PersonFactory();
			sessionFactory = factory.getSessionFactory();
			session = sessionFactory.openSession();

			/*Person person = new Person();
			System.out.println("Inserting Record");
			Transaction tx = session.beginTransaction();
			
			// Id is auto generated, @GeneratedValue.
			// person.setId(2);
			
			person.setName("Thiago 2");
			session.save(person);
			tx.commit();
			System.out.println("Done");
			*/
			Query query = session.createQuery("from Person where id = :id").setParameter("id", 2);
			List<Person> list = query.list();
			
			for (Person person : list) {
				System.out.println("Id: " + person.getId());
				System.out.println("Name: " + person.getName());
				System.out.println("");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}
}