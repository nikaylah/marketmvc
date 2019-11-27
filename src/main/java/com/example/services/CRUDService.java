package com.example.services;

import java.util.List;


//working with generics
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);
    //domain object has set by id and get by id

    void delete(Integer id);
}
