package cn.hibernatedemo.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    private static Configuration configuration;
    
    private final static SessionFactory sessionFactory;
    
    static
    {
        try
        {
            configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        catch (HibernateException ex)
        {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private HibernateUtil()
    {
    }
    
    public static Session currentSession()
    {
        return sessionFactory.getCurrentSession();
    }
}
