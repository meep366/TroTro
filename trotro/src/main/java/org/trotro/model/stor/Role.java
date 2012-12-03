// Generated by dez2hibernate
package org.trotro.model.stor;

import org.springframework.security.GrantedAuthority;

import java.io.Serializable;


public class Role implements Serializable, GrantedAuthority {
      
    private static final long serialVersionUID = -8399730652925578701L;
	
	private String ROLE_ID;
    private String ROLE_NAME;
    private String ROLE_DESC;

        
    public Role() 
    {
        super();
    }          
        
    public void setROLE_ID ( String ROLE_ID )
    {
        this.ROLE_ID = ROLE_ID;
    }

    public String getROLE_ID ( ) 
    {
        return this.ROLE_ID;
    }
      
    public void setROLE_NAME ( String ROLE_NAME )
    {
        this.ROLE_NAME = ROLE_NAME;
    }

    public String getROLE_NAME ( ) 
    {
        return this.ROLE_NAME;
    }
      
    public void setROLE_DESC ( String ROLE_DESC )
    {
        this.ROLE_DESC = ROLE_DESC;
    }

    public String getROLE_DESC ( ) 
    {
        return this.ROLE_DESC;
    }

	public String getAuthority() 
	{
		return this.getROLE_NAME();
	}

	public int compare(Role o1, Role o2) {

		if ((o1==null) && (o2!=null))
			return -1;
		if ((o1!=null) && (o2==null))
			return 1;
		if ((o1==null) && (o2==null))
			return 0;
		
		int compareValue = o1.getROLE_NAME().toLowerCase().compareTo(o2.getROLE_NAME().toLowerCase());
		
		return compareValue;
	}
	
	public int compareTo(Object o) {
		
		return compare(this,(Role)o);
	}
  
	public boolean equals(Object obj) {
		
		Role role;
		
		if (obj==null)
			return false;
		
		if (!(obj instanceof Role))
			return false;
		else
			role = (Role)obj;
		
		boolean result = (this.ROLE_NAME==null ? role.ROLE_NAME==null : this.ROLE_NAME.equals(role.ROLE_NAME));
				 
		return result;
	}
}      
      
    