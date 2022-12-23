package com.example.demo.service.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceInterface<T,D,L> {

    void save(D object);
    T findById(L id);
    List<D> getAll();
    void update(L id,D object);
    void delete(Long id);
}
