package SessionFactoryConfiguration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory=null;
    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder standard=
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(standard.build());

    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
