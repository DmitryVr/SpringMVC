package com.company.service;

import com.company.dao.UploadDao;
import com.company.model.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("uploadServiceImpl")
@Scope("singleton")
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadDao uploadDaoDatabase;

    @Override
    @Transactional
    public List<Upload> getAll() {
        return uploadDaoDatabase.getAll();
    }

    @Override
    @Transactional
    public Upload getById(int id) {
        return uploadDaoDatabase.getById(id);
    }

    @Override
    @Transactional
    public void add(Upload model) {

    }

    @Override
    @Transactional
    public void update(Upload model) {

    }

    @Override
    @Transactional
    public void delete(int id) {

    }
}
