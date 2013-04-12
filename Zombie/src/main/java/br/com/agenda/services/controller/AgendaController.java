package br.com.agenda.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agenda.dao.IAgendaDAO;
import br.com.agenda.model.Agenda;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	
	@Autowired
	IAgendaDAO agendaDAO;
	
	@RequestMapping(value="getAgendaPorId/{id}", method = RequestMethod.GET)
	public @ResponseBody Agenda getAgendaPorId(@PathVariable(value = "id") String id) {
		Agenda agenda = new Agenda();
		
		if (!"null".equals(id) && !"".equals(id)) {
			agenda.setId(new Integer(id));
		}
		
		return agenda;
	}
	
	@RequestMapping(value="getTodasAgendas", method = RequestMethod.GET)
	public @ResponseBody List<Agenda> getTodasAgendas() {
		return agendaDAO.getTodasAgendas();
	}

}
