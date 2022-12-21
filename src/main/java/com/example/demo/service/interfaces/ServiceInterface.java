package com.example.demo.service.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceInterface<T,D,L> {

    D save(D object);
    T findById(L id);
    List<T> getAll();
    void update(D object);
    void delete(Long id);
}
