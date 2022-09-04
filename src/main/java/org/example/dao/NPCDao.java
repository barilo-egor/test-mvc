package org.example.dao;

import org.example.entities.Location;
import org.example.entities.NonPlayerCharacter;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NPCDao extends BaseDao<NonPlayerCharacter>{

    @Autowired
    public NPCDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public NonPlayerCharacter save(NonPlayerCharacter nonPlayerCharacter) {
        return super.save(nonPlayerCharacter);
    }

    @Override
    public void update(NonPlayerCharacter nonPlayerCharacter) {
        super.update(nonPlayerCharacter);
    }

    @Override
    public void delete(NonPlayerCharacter nonPlayerCharacter) {
        super.delete(nonPlayerCharacter);
    }

    @Override
    public NonPlayerCharacter findById(Integer id) {
        return (NonPlayerCharacter) sessionFactory.openSession().get(NonPlayerCharacter.class, id);
    }

    @Override
    public List<NonPlayerCharacter> returnAll() {
        return sessionFactory.getCurrentSession().createCriteria(NonPlayerCharacter.class).list();
    }
}
