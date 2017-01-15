package com.company.dao;

import com.company.model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeveloperDaoDatabase implements DeveloperDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Developer> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Developer> developerList = session.createQuery("FROM Developer").list();

        return developerList;
    }

    @Override
    public Developer getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Developer developer = (Developer) session.get(Developer.class, id);

        return developer;
    }

    @Override
    public void add(Developer model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(model);
    }

    @Override
    public void update(Developer model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(model);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Developer developer = (Developer) session.get(Developer.class, id);

        if(developer != null){
            session.delete(developer);
        }
    }
}
