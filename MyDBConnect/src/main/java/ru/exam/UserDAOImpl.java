package ru.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDAOImpl implements UserDao {
    private HibernateSessionFactoryUtil sesFactory;

    UserDAOImpl(HibernateSessionFactoryUtil sessionFactory){
        sesFactory = sessionFactory;
    }

    @Override
    public Users getUser(int id) {
        return sesFactory.getSessionFactory().openSession().get(Users.class, id);
    }

    @Override
    public boolean setUser(Users user) {
        Session session = sesFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
        return true;
    }

    @Override
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
}
