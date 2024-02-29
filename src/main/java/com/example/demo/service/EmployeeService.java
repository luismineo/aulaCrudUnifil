package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    private boolean verifyId(Long id){
        return employeeRepository.existsById(id);
    }

    public List<Employee> employeeList(){
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee, Long id){
        if(verifyId(id)){
            employee.setId(id);
           return employeeRepository.save(employee);
        }
        return null;
    }

    public boolean delete(Long id){
        if(verifyId(id)){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int employeesQuantity(){
        return employeeRepository.findAll().size();
    }

    public Optional<Employee> findById(Long id){
        if (verifyId(id)){
            return employeeRepository.findById(id);
        }
        return Optional.empty();
    }
}
