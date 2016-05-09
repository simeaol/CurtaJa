package br.curtaja.com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class DataBaseConnection {
	
	public static Configuration conf ;
	public static SessionFactory factory;
	public static Session session;
	
	public static Session getSession(){
	
		// Cria uma instância para configuração
		conf = new Configuration();
		//lê o arquivo "hibernate.cfg.xml"
		conf.configure();
	
		//Cria uma fábrica de sessões
		factory = conf.buildSessionFactory();
	
		//Cria uma sessão
		session = factory.openSession();
	
		return session;
	}
	
	public static void closeDataBase(){
		
		factory.close();
		session.close();		
	}
}
