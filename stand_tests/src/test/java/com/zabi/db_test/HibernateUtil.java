package com.zabi.db_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private SessionFactory sessionFactory;

    public HibernateUtil() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }

    public Profile getEmployee() {
        Profile empl;
        try (Session session = sessionFactory.openSession()) {
            empl = session.find(Profile.class,3L);
        }
        return empl;
    }
}
