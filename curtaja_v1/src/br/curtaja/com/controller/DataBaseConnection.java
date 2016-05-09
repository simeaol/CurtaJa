package br.curtaja.com.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class DataBaseConnection {
	
	public static Configuration conf ;
	public static SessionFactory factory;
	public static Session session;
	
	public static Session getSession(){
	
		// Cria uma inst�ncia para configura��o
		conf = new Configuration();
		//l� o arquivo "hibernate.cfg.xml"
		conf.configure();
	
		//Cria uma f�brica de sess�es
		factory = conf.buildSessionFactory();
	
		//Cria uma sess�o
		session = factory.openSession();
	
		return session;
	}
	
	public static void closeDataBase(){
		
		factory.close();
		session.close();		
	}
}
