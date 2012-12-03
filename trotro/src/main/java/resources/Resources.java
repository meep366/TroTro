/*
 * Created on Feb 15, 2005
 * Created at 1:52:05 AM
 * Created by J. Croft
 * 
 * Project: appraisals
 * File:    Resources.java
 * 
 */

package resources;

import org.apache.log4j.Logger;

import java.net.URL;

/**
 * Added on Feb 15, 2005
 * Added at 1:52:05 AM
 * @author J. Croft
 *
 */

public class Resources {
    
	private static Logger logger = Logger.getLogger(Resources.class);
    private static Resources r = new Resources();

    private Resources()
    {
        
    }
    
    public static URL getResourceURL ( String pathToResource )
    {
    	URL result = null;
        
    	try {
    		logger.info("Loading: /" + pathToResource);
    		result = r.getClass().getResource(pathToResource);
    		logger.debug("Loaded: " + result.toExternalForm());
    	}
    	catch ( Exception e ) {
    		logger.error("/" + pathToResource + " not found.");
    		
    		try {
    			logger.debug("Loading: /" + pathToResource);
        		result = r.getClass().getResource("/" + pathToResource);
        		logger.debug("Loaded: " + result.toExternalForm());
    		}
    		catch ( Exception e2 ) {
    			logger.error("/" + pathToResource + " not found.");        		
    		}
    	}
    	
    	return result;
    }
}
