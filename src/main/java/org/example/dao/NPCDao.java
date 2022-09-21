package org.example.dao;

import org.example.entities.NonPlayerCharacter;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NPCDao extends BaseDao<NonPlayerCharacter> {


    public NPCDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public NonPlayerCharacter findById(Integer id) {
        return sessionFactory.openSession().get(NonPlayerCharacter.class, id);
    }

    @Override
    public List<NonPlayerCharacter> returnAll() {
        return sessionFactory.getCurrentSession().createCriteria(NonPlayerCharacter.class).list();
    }
}
