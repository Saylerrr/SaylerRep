package ru.examp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class VocDaoImpl implements VocDao{
    private HibernateSessionFactoryUtil sesFactory;

    VocDaoImpl(HibernateSessionFactoryUtil sesFactory) {
        this.sesFactory = sesFactory;
    }

    @Override
    public List<VocFirst> getVocList(String key) {
        Session session = sesFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<VocFirst> criteria = builder.createQuery(VocFirst.class);
        Root<VocFirst> employeeRoot=criteria.from(VocFirst.class);
        criteria.select(employeeRoot);
        criteria.where(builder.equal(employeeRoot.get("word_first"), "cat"));
        List<VocFirst> list=session.createQuery(criteria).getResultList();
        session.close();
        return list;
    }

    @Override
    public boolean setWord(String key, String word) {
        return false;
    }

    @Override
    public List<VocFirst> getAllVoc() {
        return null;
    }

    @Override
    public VocFirst getId(int id) {
        return sesFactory.getSessionFactory().openSession().get(VocFirst.class, id);
    }
}
