package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping
    public List<Manager> managerList(){
        return managerService.list();
    }

    @PostMapping
    public Manager create(@RequestBody Manager manager){
        return managerService.create(manager);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Manager manager, @PathVariable Long id){
        if(managerService.update(manager, id) == null){
            String message = "ID doesn't exists";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        //return ResponseEntity.ok(employeeService.update(employee, id));
        return ResponseEntity.ok(manager);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(managerService.delete(id)){
            String message = "ID: " + id + " was successfully deleted";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        String message = "ID doesn't exists";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
