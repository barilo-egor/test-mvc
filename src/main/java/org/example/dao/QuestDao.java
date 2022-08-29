package org.example.dao;

import org.example.entities.Quest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestDao implements Dao<Quest> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Quest save(Quest quest) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Integer id = (Integer) session.save(quest);
            quest = findById(id);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return quest;
    }

    @Override
    public Quest findById(Integer id) {
        return (Quest) sessionFactory.openSession().get(Quest.class, id);
    }

    @Override
    public void update(Quest quest) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(quest);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Quest quest) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(quest);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }
}
