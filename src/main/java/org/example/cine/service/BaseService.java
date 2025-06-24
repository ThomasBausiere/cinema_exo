package org.example.cine.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T, U>{

    //CREAT
    T save(U entity);
    //READ1
    T findById(UUID id);
    //READ ALL
    List<T> findAll();
    //UPDATE
    T update(UUID id, U u);
    //DELETE
    void deleteById(UUID id);

}
