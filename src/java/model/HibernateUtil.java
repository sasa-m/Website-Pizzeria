
package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    
    private static SessionFactory sessionFactory = null;
    
    
    public static SessionFactory getSessionFactory(){
        
        if(sessionFactory==null){
            Configuration config = new Configuration();
            config.configure("/config/hibernate.cfg.xml");
            ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(sr);
        }
        
        return sessionFactory;
    }
    
}
