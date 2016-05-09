package br.curtaja.com.controller;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.Session;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.curtaja.com.controller.dao.EventoDao;
import br.curtaja.com.model.Evento;

@Controller
public class EventoController {
	
	EventoDao eDao;
	Session session;
	
	public EventoController(){
		
	}
	
	@Inject
	public EventoController(Session session, EventoDao eDao){
		this.session = session;
		this.eDao = eDao;
	}
	
	@Get
	@Path("/bares")
	public List<Evento> listaBares(){
		return eDao.listaPorCategoria(1);
		
	}
	
	@Get
	@Path("/discotecas")
	public List<Evento> listaDiscotecas(){
		return eDao.listaPorCategoria(2);
		
	}
	
	@Get
	@Path("/festas}")
	public List<Evento> listaFestas(){
		return eDao.listaPorCategoria(3);
		
	}
	
	@Get
	@Path("/shows}")
	public List<Evento> listaShows(){
		return eDao.listaPorCategoria(4);
		
	}
	
	@Get
	@Path("/djsebandas}")
	public List<Evento> listaDjseBandas(){
		return eDao.listaPorCategoria(5);
		
	}

}
