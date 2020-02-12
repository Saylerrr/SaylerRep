package ru.exam.dataConnection;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.exam.dictionaries.VocFirst;
import ru.exam.dictionaries.Vocabulary;

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
