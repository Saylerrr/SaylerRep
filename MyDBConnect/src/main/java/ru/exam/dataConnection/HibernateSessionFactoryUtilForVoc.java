package ru.exam.dataConnection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.exam.dictionaries.VocFirst;
import ru.exam.dictionaries.VocSecond;

public class HibernateSessionFactoryUtilForVoc {
    private SessionFactory sessionFactory;

    HibernateSessionFactoryUtilForVoc() {
    }

    public  SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(VocFirst.class);
                configuration.addAnnotatedClass(VocSecond.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
