package com.config;

import org.hibernate.cfg.AnnotationConfiguration;



import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	static{
		try{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}
		catch (Throwable ex) {
			System.err.println("Initial SessionFactiry Creation failed"+ex);
			throw new  ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	
}
