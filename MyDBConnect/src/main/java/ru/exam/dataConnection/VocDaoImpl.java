package ru.exam.dataConnection;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.exam.dictionaries.VocFirst;
import ru.exam.dictionaries.Vocabulary;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class VocDaoImpl implements VocDao {
    private HibernateSessionFactoryUtilForVoc sesFactory;

    VocDaoImpl(HibernateSessionFactoryUtilForVoc sessionFactory){
        sesFactory = sessionFactory;
    }

//    public VocFirst getUser(int id) {
//        return sesFactory.getSessionFactory().openSession().get(VocFirst.class, id);
//    }

    public boolean setVoc (Vocabulary voc){
        Session session = sesFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(voc);
        tx1.commit();
        session.close();
        System.out.println(voc);
        return true;
    }

    public <T> List<T>  getWordByKey (String key, Class<T> clazz) {
        Session session = sesFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(clazz);
        Root<T> employeeRoot=criteria.from(clazz);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("word_first"), key));
        List<T> list = session.createQuery(criteria).getResultList();
        session.close();
        System.out.println(list);
        return list;
    }

    public <T> List<T> getAllVoc(Class<T> clazz, String table){
        Session session = sesFactory.getSessionFactory().openSession();
        List<T> list = session.createSQLQuery("SELECT * FROM " + table).addEntity(clazz).list();
        session.close();
        System.out.println(list);
        return list;

    }

    public boolean delVoc (Vocabulary voc) {
        Session session = sesFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(voc);
        tx1.commit();
        session.close();
        System.out.println(voc);
        return true;
    }


    /*public boolean setUser(Users user) {
        Session session = sesFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
        return true;
    }


    public List<Users> getUsersList(String name) {
        Session session = sesFactory.getSessionFactory().openSession();//getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
        Root<Users> employeeRoot=criteria.from(Users.class);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("user"), "John"));
        List<Users> list=session.createQuery(criteria).getResultList();
        session.close();
        return list;
    }


    public List<Users> getUsersNativList(String name) {
        Session session = sesFactory.getSessionFactory().openSession();
        List<Users> list = session.createSQLQuery("SELECT * FROM USERS where user = '"+name+"'").addEntity(Users.class).list();
        session.close();
        return list;
    }*/
}
