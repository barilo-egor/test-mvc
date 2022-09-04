package org.example.dao;

import org.example.entities.BasePersist;
import org.hibernate.SessionFactory;
import java.util.List;

public abstract class BaseDao<T extends BasePersist> {

    public SessionFactory sessionFactory;

    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T save(T t) {
        Integer id  = (Integer) sessionFactory.getCurrentSession().save(t);
        t.setId(id);
        return t;
    }

    public abstract T findById(Integer id);

    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    public abstract List<T> returnAll();
}
