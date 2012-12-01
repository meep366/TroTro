/*
 * Created on Dec 21, 2005
 * Created at 1:53:47 AM
 * Created by Administrator
 * 
 * Project: model
 * File:    HibernateUtil.java
 * 
 */

package util.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.cfg.*;
import resources.Resources;

import java.net.URL;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(HibernateUtil.class);
	
	public static String cfgFileName = "hibernate-test.cfg.xml";

	static {

        try {
		logger.info("Loading the hibernate properties");

            // Create the SessionFactory from hibernate-test.cfg.xml
            if (System.getProperty("hibernate.config")!=null)
            	cfgFileName = System.getProperty("hibernate.config");
            
            URL cfgURL = Resources.getResourceURL(cfgFileName);
    		logger.info("from URL: " + cfgURL);
            Configuration cfg = new Configuration().configure(cfgURL);
            if (System.getProperty("connection.driver_class")!=null)
            	cfg.setProperty("connection.driver_class", System.getProperty("connection.driver_class"));
            if (System.getProperty("connection.url")!=null)
            	cfg.setProperty("connection.url", System.getProperty("connection.url"));
            if (System.getProperty("connection.username")!=null)
            	cfg.setProperty("connection.username", System.getProperty("connection.username"));
            if (System.getProperty("connection.password")!=null)
            	cfg.setProperty("connection.password", System.getProperty("connection.password"));
            sessionFactory = cfg.buildSessionFactory();
        
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

	public static void getInstance ( String configFileName ) {
		
        try {
    		logger.info("Loading the hibernate properties");

    		HibernateUtil.cfgFileName = configFileName;

    		// Create the SessionFactory from hibernate-test.cfg.xml
            if (System.getProperty("hibernate.config")!=null)
            	cfgFileName = System.getProperty("hibernate.config");
            
            URL cfgURL = Resources.getResourceURL(cfgFileName);
    		logger.info("from URL: " + cfgURL);
            Configuration cfg = new Configuration().configure(cfgURL);
            if (System.getProperty("connection.driver_class")!=null)
            	cfg.setProperty("connection.driver_class", System.getProperty("connection.driver_class"));
            if (System.getProperty("connection.url")!=null)
            	cfg.setProperty("connection.url", System.getProperty("connection.url"));
            if (System.getProperty("connection.username")!=null)
            	cfg.setProperty("connection.username", System.getProperty("connection.username"));
            if (System.getProperty("connection.password")!=null)
            	cfg.setProperty("connection.password", System.getProperty("connection.password"));
            sessionFactory = cfg.buildSessionFactory();
        
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
	
    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }
}