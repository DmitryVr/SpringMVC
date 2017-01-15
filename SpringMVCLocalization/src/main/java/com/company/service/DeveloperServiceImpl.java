package com.company.service;

import com.company.dao.DeveloperDao;
import com.company.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    private DeveloperDao developerDaoDatabase;

    @Override
    @Transactional
    public List<Developer> getAll() {
        return null;
    }

    @Override
    @Transactional
    public Developer getById(int id) {
        return developerDaoDatabase.getById(id);
    }

    @Override
    @Transactional
    public void add(Developer model) {

    }

    @Override
    @Transactional
    public void update(Developer model) {

    }

    @Override
    @Transactional
    public void delete(int id) {

    }
}
