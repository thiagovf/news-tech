package br.com.agenda.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.dao.IAgendaDAO;
import br.com.agenda.model.Agenda;

@Repository
@Transactional(readOnly = false)
public class AgendaDAOImpl implements IAgendaDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public AgendaDAOImpl() {
	}
	
	public void salva(Agenda agenda) {
		sessionFactory.getCurrentSession().saveOrUpdate(agenda);
	}
	
	public List<Agenda> getTodasAgendas() {
		String Sql = "from Agenda";

		@SuppressWarnings("unchecked")
		List<Agenda> list = (List<Agenda>) this.sessionFactory
				.getCurrentSession().createQuery(Sql).list();
		
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
