package br.com.agenda.dao;

import java.util.List;

import br.com.agenda.model.Agenda;

public interface IAgendaDAO {
	public void salva(Agenda agenda);
	public List<Agenda> getTodasAgendas();
}
