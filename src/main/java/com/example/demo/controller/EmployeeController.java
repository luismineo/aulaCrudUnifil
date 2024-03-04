package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> employeeList(){
        return employeeService.employeeList();
    }

    @PostMapping
    public Employee create(@Valid @RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Long id){
        if(employeeService.update(employee, id) == null){
            String message = "ID doesn't exists";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        //return ResponseEntity.ok(employeeService.update(employee, id));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(employeeService.delete(id)){
            String message = "ID: " + id + " was successfully deleted";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        String message = "ID doesn't exists";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @GetMapping("/size")
    public int size(){
        return employeeService.employeesQuantity();
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(Long id){
        return employeeService.findById(id);
    }
}
