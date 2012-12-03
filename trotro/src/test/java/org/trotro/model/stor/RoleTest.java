/*
 * Created on Dec 21, 2005
 * Created at 2:17:02 AM
 * Created by Administrator
 * 
 * Project: ku2
 * File:    RoleTest.java
 * 
 */

package org.trotro.model.stor;

import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;

public class RoleTest extends TestCase {

    private static Logger logger = Logger.getLogger(RoleTest.class);
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(RoleTest.class);
    }

    public RoleTest(String arg0) 
    {
        super(arg0);
        System.setProperty("hibernate.config", "hibernate-net.cfg.xml");
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        HibernateUtil.getSessionFactory().close();
    }

    /*
     * Test method for 'com.atlpro.model.stor.Person()'
     */
    public void testRole() 
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<?> roleList = session.createQuery("FROM Role").list();
        logger.debug("Number of roles: " + roleList.size());
        Role role = new Role();
        role.setROLE_NAME("ROLE_TEST");
        role.setROLE_DESC("Role for testing.");
        session.save(role);
        session.flush();
        session.getTransaction().commit();
        session.beginTransaction();
        session.delete(role);
        session.flush();
        session.getTransaction().commit();
    }
}
