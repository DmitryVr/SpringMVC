package com.company.dao;

import com.company.model.Upload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UploadDaoDatabase implements UploadDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Upload> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Upload> developerList = session.createQuery("FROM Upload").list();

        return developerList;
    }

    @Override
    public Upload getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Upload developer = (Upload) session.get(Upload.class, id);

        return developer;
    }

    @Override
    public void add(Upload model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(model);
    }

    @Override
    public void update(Upload model) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(model);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Upload developer = (Upload) session.get(Upload.class, id);

        if(developer != null){
            session.delete(developer);
        }
    }
}
