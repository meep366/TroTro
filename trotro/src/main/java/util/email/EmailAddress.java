package util.email;

/* Copyright (C) 2002-2006 Les Hazlewood
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
 * Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License 
 * along with this library; if not, write to the 
 * Free Software Foundation, Inc. 
 * 59 Temple Place, Suite 330 
 * Boston, MA 02111-1307 
 * USA 
 * Or, you may view it online at 
 * http://www.opensource.org/licenses/lgpl-license.php */ 

import java.util.regex.Pattern;

/** 
 * An email address represents the textual string of an 
 * <a href="http://www.ietf.org/rfc/rfc2822.txt">RFC 2822</a> email address and other corresponding 
 * information of interest. 
 * 
 * @author Les Hazlewood */ 

public class EmailAddress extends Object { 
	
	//RFC 2822 token definitions for valid email - only used together to form a java Pattern object: 
	private static final String sp = "\\!\\#\\$\\%\\&\\'\\*\\+\\-\\/\\=\\?\\^\\_\\`\\{\\|\\}\\~"; 
	private static final String atext = "[a-zA-Z0-9" + sp + "]"; 
	private static final String atom = atext + "+"; 
	//one or more atext chars 
	private static final String dotAtom = "\\." + atom; 
	private static final String localPart = atom + "(" + dotAtom + ")*"; 
	//one atom followed by 0 or more dotAtoms. 
	//RFC 1035 tokens for domain names: 
	private static final String letter = "[a-zA-Z]"; 
	private static final String letDig = "[a-zA-Z0-9]"; 
	private static final String letDigHyp = "[a-zA-Z0-9-]"; 
	public static final String rfcLabel = letDig + letDigHyp + "{0,61}" + letDig; 
	private static final String domain = rfcLabel + "(\\." + rfcLabel + ")*\\." + letter + "{2,6}"; 
	//Combined together, these form the allowed email regexp allowed by RFC 2822: 
	private static final String addrSpec = "^" + localPart + "@" + domain + "$"; 
	//now compile it: 
	public static final Pattern VALID_PATTERN = Pattern.compile( addrSpec ); 
	private String text; 
	private boolean bouncing = true; 
	private boolean verified = false; 
	private String label; 
	
	public EmailAddress() { super(); } 
	
	public EmailAddress( String text ) { super(); setText( text ); } 
	/** 
	 * Returns the actual email address string, e.g. <tt>someone@somewhere.com</tt> 
	 * @return the actual email address string. */ 
	public String getText() { return text; } 
	public void setText( String text ) { this.text = text; } 
	/** 
	 * Returns whether or not any emails sent to this email address come back as bounced 
	 * (undeliverable). 
	 * 
	 * <p>Default is <tt>false</tt> for convenience's sake - if a bounced message is ever received for this 
	 * address, this value should be set to <tt>true</tt> until verification can made. 
	 * 
	 * @return whether or not any emails sent to this email address come back as bounced 
	 * (undeliverable). */ 
	public boolean isBouncing() { return bouncing; } 
	public void setBouncing( boolean bouncing ) { this.bouncing = bouncing; } 
	/** 
	 * Returns whether or not the party associated with this email has verified that it is 
	 * their email address. 
	 * 
	 * <p>Verification is usually done by sending an email to this 
	 * address and waiting for the party to respond or click a specific link in the email. 
	 *
	 * <p>Default is <tt>false</tt>. 
	 *
	 * @return whether or not the party associated with this email has verified that it is 
	 * their email address. */ 
	public boolean isVerified() { return verified; } 
	public void setVerified( boolean verified ) { this.verified = verified; } 
	/** 
	 * Party label associated with this address, for example, 'Home', 'Work', etc. 
	 * @return a label associated with this address, for example 'Home', 'Work', etc. */ 
	public String getLabel() { return label; } 
	public void setLabel( String label ) { this.label = label; } 
	/** 
	 * Returns whether or not the text represented by this object instance is valid according to the <tt>RFC 2822</tt> rules. 
	 * @return true if the text represented by this instance is valid according to RFC 2822, false otherwise. */ 
	public boolean isValid() { return isValidText( getText() ); } 
	/** 
	 * Utility method that checks to see if the specified string is a valid email address according to the 
	 * RFC 2822 specification. 
	 * @param email the email address string to test for validity. 
	 * @return true if the given text valid according to RFC 2822, false otherwise. */ 
	public static boolean isValidText( String email ) { return ( email != null ) && VALID_PATTERN.matcher( email ).matches(); } 
	//subclass implementation of super's template method onEquals. 
	public boolean onEquals( Object o ) { if ( o instanceof EmailAddress ) { EmailAddress ea = (EmailAddress)o; return getText().equals( ea.getText() ); } return false; } 
	public int hashCode() { return getText().hashCode(); } 
	@Override 
	public Object clone() {
		EmailAddress clone = null;
		try {
			clone = (EmailAddress)super.clone();
		} catch ( CloneNotSupportedException e ) { 
			e.printStackTrace();
		}
		clone.setText( getText() ); 
		clone.setBouncing( isBouncing() ); 
		clone.setVerified( isVerified() ); 
		clone.setLabel( getLabel() ); 
		return clone; 
	}
	
	public StringBuffer toStringBuffer() { return new StringBuffer(getText() ); } 
}
