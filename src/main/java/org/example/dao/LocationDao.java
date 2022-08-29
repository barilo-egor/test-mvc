package org.example.dao;

import org.example.entities.Location;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationDao implements Dao<Location> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Location save(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Integer id = (Integer) session.save(location);
            location = findById(id);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return location;
    }

    @Override
    public Location findById(Integer id) {
        return (Location) sessionFactory.openSession().get(Location.class, id);
    }

    @Override
    public void update(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(location);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(location);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }
}
