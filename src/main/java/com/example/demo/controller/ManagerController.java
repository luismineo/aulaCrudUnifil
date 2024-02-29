package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerRepository managerRepository;

    @GetMapping
    public List<Manager> managerList(){
        return managerRepository.findAll();
    }

    @PostMapping
    public Manager create(@RequestBody Manager manager){
        return managerRepository.save(manager);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Manager> update(@PathVariable Long id, @RequestBody Manager manager){
//        if(managerRepository.existsById(id)){
//            manager.setId(id);
//            return managerRepository.save(manager);
//        } else{
//            return null;
//        };
//    }

}
