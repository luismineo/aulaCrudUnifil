package com.example.demo.service;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService implements PersonService<Manager> {
    @Autowired
    ManagerRepository managerRepository;

    @Override
    public List<Manager> list() {
        return managerRepository.findAll();
    }

    @Override
    public Manager create(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager update(Manager manager, Long id) {
        if (managerRepository.existsById(id)){
            manager.setId(id);
            return managerRepository.save(manager);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if(managerRepository.existsById(id)){
            managerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
