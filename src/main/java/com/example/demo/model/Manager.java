package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manager extends Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String password;
    private int numberEmployees;

    public Manager(String name, String cpf, String sex, long id, double salary, long id1, String password, int numberEmployees) {
        super(name, cpf, sex, id, salary);
        this.id = id1;
        this.password = password;
        this.numberEmployees = numberEmployees;
    }

    public Manager(long id, double salary, long id1, String password, int numberEmployees) {
        super(id, salary);
        this.id = id1;
        this.password = password;
        this.numberEmployees = numberEmployees;
    }

    public Manager(long id, String password, int numberEmployees) {
        this.id = id;
        this.password = password;
        this.numberEmployees = numberEmployees;
    }

    public Manager() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(int numberEmployees) {
        this.numberEmployees = numberEmployees;
    }
}
