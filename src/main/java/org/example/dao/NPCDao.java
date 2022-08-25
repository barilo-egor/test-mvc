package org.example.dao;

import org.example.entities.NonPlayerCharacter;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;

public class NPCDao implements Dao<NonPlayerCharacter>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public NonPlayerCharacter save(NonPlayerCharacter npc) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Integer id = (Integer) session.save(npc);
            npc = findById(id);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return npc;
    }

    @Override
    public NonPlayerCharacter findById(Integer id) {
        return sessionFactory.openSession().get(NonPlayerCharacter.class, id);
    }

    @Override
    public void update(NonPlayerCharacter npc) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(npc);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(NonPlayerCharacter npc) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(npc);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }
}
