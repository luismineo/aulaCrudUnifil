package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.Person;

import java.util.List;

public interface PersonService <T extends Person>{

    List<T> list();

    T create(T t);

    T update(T t, Long id);

    boolean delete(Long id);


}
