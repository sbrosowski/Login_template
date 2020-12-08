package pma.dao.session;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    private static SessionFactory ourSessionFactory;

    private static SessionManager _INSTANCE;


    public SessionManager getInstance() {
        if (_INSTANCE == null) {
            _INSTANCE = new SessionManager();
        }
        return _INSTANCE;
    }

    public void initSessionConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure();

        ourSessionFactory = configuration.buildSessionFactory();
    }

    public Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public void closeSession(Session session) throws HibernateException {
        session.close();
    }
}
