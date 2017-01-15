package com.company.service;

import com.company.model.Model;

import java.util.List;

/**
 * интерфейс для интерфейсов service
 */
public interface ItemService<T extends Model> {
    List<T> getAll();

    T getById(int id);

    void add(T model);

    void update(T model);

    void delete(int id);
}
