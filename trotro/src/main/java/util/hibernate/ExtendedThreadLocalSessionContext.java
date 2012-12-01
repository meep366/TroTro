/*
 * Created on Jan 7, 2006
 * Created at 4:13:09 PM
 * Created by Administrator
 * 
 * Project: model
 * File:    ExtendedThreadLocalSessionContext.java
 * 
 */

package util.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.context.ThreadLocalSessionContext;
import org.hibernate.engine.SessionFactoryImplementor;

public class ExtendedThreadLocalSessionContext extends ThreadLocalSessionContext {

    private static final long serialVersionUID = 5902559994668547217L;
    
    private static final Log log = LogFactory.getLog( ExtendedThreadLocalSessionContext.class );

    public ExtendedThreadLocalSessionContext(SessionFactoryImplementor factory) {
        super(factory);
    }

    // Always set FlushMode.NEVER on any Session
    protected org.hibernate.classic.Session buildOrObtainSession() {
        log.debug("Opening a new Session");
        Session s = super.buildOrObtainSession();

        log.debug("Disabling automatic flushing of the Session");
        s.setFlushMode(FlushMode.MANUAL);

        return s;
    }

    // No automatic flushing of the Session at transaction commit, client calls flush()
    protected boolean isAutoFlushEnabled() { return false; }

    // No automatic closing of the Session at transaction commit, client calls close()
    protected boolean isAutoCloseEnabled() { return false; }

    // Don't unbind after transaction completion, we expect the client to do this
    // so it can flush() and close() if needed (or continue the conversation).
    protected CleanupSynch buildCleanupSynch() {
        return new NoCleanupSynch(factory);
    }
    private static class NoCleanupSynch extends ThreadLocalSessionContext.CleanupSynch {

        private static final long serialVersionUID = 6905125857420681840L;
        public NoCleanupSynch(SessionFactory factory) { super(factory); }
        public void beforeCompletion() {}
        public void afterCompletion(int i) {}
    }
}
