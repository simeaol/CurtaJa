package br.curtaja.com.controller.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.curtaja.com.controller.DataBaseConnection;
import br.curtaja.com.controller.EventoController;
import br.curtaja.com.model.Evento;

public class EventoDao {
	
	Session session;
	Transaction tx;
	
	//@Inject
	//Result result;
	
	public void cadastrar(Evento evento){
		
		// get the instance of created Session
		session = DataBaseConnection.getSession();
		// open the transaction
		tx = session.beginTransaction();
		//save the object
		session.save(evento);
		//commit the transaction
		tx.commit();
		//close the session and sessionFactory
		DataBaseConnection.closeDataBase();
		
		//result.redirectTo(EventoController.class).listaPeloCliente();
		
	}
	
	public void atualizar(Evento evento){
		// get the instance of created Session
				session = DataBaseConnection.getSession();
				// open the transaction
				tx = session.beginTransaction();
				//save the object
				session.update(evento);
				//commit the transaction
				tx.commit();
				//close the session and sessionFactory
				DataBaseConnection.closeDataBase();
				//result.redirectTo(EventoController.class).listaPeloCliente();	
		
	}
	
	public void remover(Evento evento){
		// get the instance of created Session
				session = DataBaseConnection.getSession();
				// open the transaction
				tx = session.beginTransaction();
				//save the object
				session.delete(evento);
				//commit the transaction
				tx.commit();
				//close the session and sessionFactory
				DataBaseConnection.closeDataBase();
				
				//redireciona o usuário
			//	result.redirectTo(EventoController.class).listaPeloCliente();
		
	}
	
	public List<Evento> listaTudo(){
		session = DataBaseConnection.getSession();
		SQLQuery q = session.createSQLQuery("select * from eventos");
		List<Evento> eventos = q.list();
		
		DataBaseConnection.closeDataBase();
		return eventos;
	}
	
	public List<Evento> listaPorCategoria(int id){
		session = DataBaseConnection.getSession();
		SQLQuery q = session.createSQLQuery("select e.evento_nome, e.evento_endereco, e.evento_cidade, e.preco, e.evento_data, clientes.cliente_nome_empresa, clientes.cliente_telefone, e.evento_descricao, e.evento_image_path "
				+ "from eventos as e, clientes, categorias "
				+ "where categorias.idCategoria="+ id +"clientes.cliente_idCategoria = categorias.'idCategoria' and clientes.'idCliente' = e.'eventos_idCliente' order by e.evento_data");
		List<Evento> eventos = q.list();
		return eventos;
	}
	
	public List<Evento> listaPorCliente(String email){
		session = DataBaseConnection.getSession();
		SQLQuery q = session.createSQLQuery("select e.evento_nome, e.evento_endereco, e.evento_cidade, e.preco, e.evento_data, clientes.cliente_nome_empresa, clientes.cliente_telefone, e.evento_descricao, e.evento_image_path "
				+ "from eventos as e, clientes, categorias "
				+ "where clientes.cliente_email="+ email +"clientes.cliente_idCategoria = categorias.'idCategoria' and clientes.'idCliente' = e.'eventos_idCliente' order by e.evento_data");
		
		List<Evento> eventos = q.list();
		return eventos;
	}

}
