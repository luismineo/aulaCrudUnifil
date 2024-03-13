package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private String name;

//    @NotNull
//    @Size(min = 11, max = 13)
//    @Column(nullable = false)
//    private String cpf;

    @NotNull
    @Column(nullable = false)
    @Min(1)
    private double salary;

    public Employee(String name, String cpf, String sex, long id, double salary) {
        super(name, cpf, sex);
        this.id = id;
        this.salary = salary;
    }

    public Employee(long id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
