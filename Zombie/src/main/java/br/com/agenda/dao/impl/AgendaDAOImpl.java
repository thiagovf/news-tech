package br.com.agenda.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.agenda.dao.IAgendaDAO;
import br.com.agenda.model.Agenda;

@Repository
public class AgendaDAOImpl implements IAgendaDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public AgendaDAOImpl() {
	}
	
	@Override
	public void salva(Agenda agenda) {
		sessionFactory.getCurrentSession().saveOrUpdate(agenda);
	}
	
	@Override
	public List<Agenda> getTodasAgendas() {
		String Sql = "select distinct new Agenda(u.id)";

		@SuppressWarnings("unchecked")
		List<Agenda> list = (List<Agenda>) this.sessionFactory
				.getCurrentSession().createQuery(Sql).list();
		
		return list;
	}

}
