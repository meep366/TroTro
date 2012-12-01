/*
 * Created on Dec 21, 2005
 * Created at 3:12:39 PM
 * Created by Administrator
 * 
 * Project: util
 * File:    RandomGUIDGenerator.java
 * 
 */

package util.hibernate;

import util.datatypes.RandomGUID;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class RandomGUIDGenerator implements IdentifierGenerator {

    public RandomGUIDGenerator() {

    	super();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {


    }

    public Serializable generate(SessionImplementor arg0, Object arg1) 
        throws HibernateException 
    {
        String strGuid = new RandomGUID().toString(); 
        return strGuid;
    }

}
