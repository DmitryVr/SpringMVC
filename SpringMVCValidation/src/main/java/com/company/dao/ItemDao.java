package com.company.dao;

import com.company.model.Model;

import java.util.List;

/**
 * интерфейс для интерфейсов dao
 */
public interface ItemDao<T extends Model> {

    List<T> getAll();

    T getById(int id);

    void add(T model);

    void update(T model);

    void delete(int id);
}