package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    static SessionFactory SF;
    static {
        SF = new Configuration().configure().buildSessionFactory();
    }
    public interface Hibernate<T> {
        T resultHibernate(Session session);
    }
    public static <T> T handle(Hibernate<T> hibernate){
        Session session = SF.openSession();
        Transaction transaction = session.beginTransaction();
        T tt = hibernate.resultHibernate(session);
        transaction.commit();
        session.close();
        return tt;
    }



}
