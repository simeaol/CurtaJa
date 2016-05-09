package br.curtaja.com.controller.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.curtaja.com.controller.DataBaseConnection;
import br.curtaja.com.model.Cliente;

public class ClienteDao {
	
	Session session;
	Transaction tx;
	
	public void cadastrar(Cliente cliente){
		
		// get the instance of created Session
		session = DataBaseConnection.getSession();
		// open the transaction
		tx = session.beginTransaction();
		//save the object
		session.save(cliente);
		SQLQuery q = session.createSQLQuery("insert into clientes(cliente_nome, cliente_email, cliente_cpf, cliente_nome_empresa, cliente_endereco, cliente_cidade, cliente_telefone, cliente_senha, cliente_logo_path, data_cadastro, data_limite, cliente_idPlano) values("+
		             cliente.getNome()
				+","+cliente.getEmail()
				+","+cliente.getCpf()
				+","+cliente.getEmpresa()
				+","+cliente.getEndereco()
				+","+cliente.getCidade()
				+","+cliente.getTelefone()
				+","+cliente.getSenha()
				+","+cliente.getLogo()
				+","+cliente.getDataLimite()
				+","+cliente.getDataCadastro()
				+","+cliente.getCategoria()
				+")");
		q.executeUpdate();
		//session.save(cliente);
		//commit the transaction
		tx.commit();
		//close the session and sessionFactory
		DataBaseConnection.closeDataBase();
		
	}
	
	public void atualizar(Cliente cliente){
		// get the instance of created Session
				session = DataBaseConnection.getSession();
				// open the transaction
				tx = session.beginTransaction();
				//save the object
				session.update(cliente);
				//commit the transaction
				tx.commit();
				//close the session and sessionFactory
				DataBaseConnection.closeDataBase();
		
		
	}
	
	public void remover(Cliente cliente){
				// get the instance of new created Session
				session = DataBaseConnection.getSession();
				// open the transaction
				tx = session.beginTransaction();
				//save the object
				session.delete(cliente);
				//commit the transaction
				tx.commit();
				//close the session and sessionFactory
				DataBaseConnection.closeDataBase();
		
	}
	//Retrieve client by cpf
	public List<?> retornaCliente(String cpf){
		//Get the instance of the new created Session
		session = DataBaseConnection.getSession();
		//create sql to query client by cpf
		SQLQuery q = session.createSQLQuery("select * from clientes where cpf="+cpf);
		//save the result into a list
		List<?> clientes = q.list();
		//Close the database connection
		DataBaseConnection.closeDataBase();
		//return the list of found's clients
		return clientes;
		
	}
	//retrieve client by email and password
	public boolean verificarLogin(String email, String senha){
		//Get the instance of the new created Session
		session = DataBaseConnection.getSession();
		//create sql to query client by email and password
		SQLQuery q = session.createSQLQuery("select * from clientes as c"
				+ " where c.cliente_email="+email+" and c.cliente_senha="+senha);
		//Close the database connection
		DataBaseConnection.closeDataBase();
		//return false if file is empty, otherwise, return true
		return !q.list().isEmpty();
		
	}

}
