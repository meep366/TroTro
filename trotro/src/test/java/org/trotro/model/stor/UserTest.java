package org.trotro.model.stor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import util.hibernate.HibernateUtil;

import junit.framework.TestCase;

public class UserTest extends TestCase {

	private static Logger logger = Logger.getLogger(UserTest.class);
    
    public static void main(String[] args) {
    	junit.textui.TestRunner.run(UserTest.class);
	}

	public UserTest(String name) {
		super(name);
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
    public void testUser()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<?> userList = session.createQuery("FROM User").list();
        logger.debug("Number of users: " + userList.size());
        Role role = new Role();
        role.setROLE_NAME("ROLE_TEST");
        role.setROLE_DESC("Role for testing.");
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        User user = new User();
        user.setUSR_LOGIN("test");
        user.setRoles(roles);
        session.save(user);
        session.flush();
        session.getTransaction().commit();
        session.beginTransaction();
        session.delete(user);
        session.flush();
        session.getTransaction().commit();
    }
}
