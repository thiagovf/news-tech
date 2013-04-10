package br.com.agenda.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agenda.model.Agenda;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	
	@RequestMapping(value="getAgendaPorId/{id}", method = RequestMethod.GET)
	public @ResponseBody Agenda getShopInJSON(@PathVariable(value = "id") String id) {
		Agenda agenda = new Agenda();
		
		if (!"null".equals(id) && !"".equals(id)) {
			agenda.setId(new Integer(id));
		}
		
		return agenda;
	}

}
