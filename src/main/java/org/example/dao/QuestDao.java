package org.example.dao;

import org.example.entities.Location;
import org.example.entities.Quest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestDao extends BaseDao<Quest> {

    @Autowired
    public QuestDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Quest save(Quest quest) {
        return super.save(quest);
    }

    @Override
    public void update(Quest quest) {
        super.update(quest);
    }

    @Override
    public void delete(Quest quest) {
        super.delete(quest);
    }

    @Override
    public Quest findById(Integer id) {
        return (Quest) sessionFactory.openSession().get(Quest.class, id);
    }

    @Override
    public List<Quest> returnAll() {
        return sessionFactory.getCurrentSession().createCriteria(Quest.class).list();
    }
}
