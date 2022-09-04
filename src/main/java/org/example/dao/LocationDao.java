package org.example.dao;

import org.example.entities.Location;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class LocationDao extends BaseDao<Location> {

    @Autowired
    public LocationDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Location save(Location location) {
        return super.save(location);
    }

    @Override
    public void update(Location location) {
        super.update(location);
    }

    @Override
    public void delete(Location location) {
        super.delete(location);
    }

    @Override
    public Location findById(Integer id) {
        return (Location) sessionFactory.openSession().get(Location.class, id);
    }



    @Override
    public List<Location> returnAll() {
        return sessionFactory.getCurrentSession().createCriteria(Location.class).list();
    }
}
