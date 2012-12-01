/*
 * Created on Feb 18, 2006
 * Created at 10:34:11 PM
 * Created by Administrator
 * 
 * Project: ku2
 * File:    RandomGUIDType.java
 * 
 */

package util.hibernate;

import util.datatypes.RandomGUID;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class RandomGUIDType implements UserType {

    private static final int[] SQL_TYPES = new int[] { Types.VARCHAR };
    
    public int[] sqlTypes() 
    {
        return SQL_TYPES;
    }

    public Class<RandomGUID> returnedClass() 
    {
        return RandomGUID.class;
    }

    public boolean equals(Object o1, Object o2) throws HibernateException 
    {
        return (o1==o2) || ( o1!=null && o2!=null && o1.equals(o2) );
    }

    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) 
        throws HibernateException, SQLException 
    {
        String strGuid = rs.getString(names[0]);
        if ( rs.wasNull() ) 
            return null;
        return new RandomGUID(strGuid);
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index) 
        throws HibernateException, SQLException 
    {
        if (value==null) 
            st.setNull(index, Types.VARCHAR);
        else 
            st.setString(index, ((RandomGUID)value).toString());
    }

    public Object deepCopy(Object o) throws HibernateException 
    {
        return o;
    }

    public boolean isMutable() 
    {
        return false;
    }

    public int hashCode(Object arg0) throws HibernateException {

        return 0;
    }

    public Serializable disassemble(Object arg0) throws HibernateException {

        return null;
    }

    public Object assemble(Serializable arg0, Object arg1) throws HibernateException {

        return null;
    }

    public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {

        return null;
    }
}
