package br.com.feirasverdes.backend.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import br.com.feirasverdes.backend.entidade.Endereco;


public class HibernateUtil {
	
	 private static final SessionFactory sessionFactory;
	 
	    static {
	        try {
	            Configuration cfg = new Configuration();
	            cfg.addAnnotatedClass(Endereco.class);

	            cfg.configure("/br/com/jsf/dao/hibernate.cfg.xml");
	            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
	            sessionFactory = cfg.buildSessionFactory(build.build());
	        } catch (HibernateException ex) {
	            System.err.println("Erro ao criar Hibernate util." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    public static Session abrirSessao() {
	        return sessionFactory.openSession();
	    }

}
