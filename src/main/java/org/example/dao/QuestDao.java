package org.example.dao;

import org.example.entities.Quest;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestDao extends BaseDao<Quest> {


    public QuestDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Quest findById(Integer id) {
        return sessionFactory.openSession().get(Quest.class, id);
    }

    @Override
    public List<Quest> returnAll() {
        return sessionFactory.getCurrentSession().createCriteria(Quest.class).list();
    }
}
