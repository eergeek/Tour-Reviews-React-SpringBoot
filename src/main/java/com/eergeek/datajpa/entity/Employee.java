package com.eergeek.datajpa.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id = -1;

    private String name;
    private String region;

    @Column(name = "salary")
    private double rupees;

    public Employee() {
    }

    public Employee(String name, String region, double rupees) {
        this.name = name;
        this.region = region;
        this.rupees = rupees;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getRupees() {
        return rupees;
    }

    public void setRupees(double rupees) {
        this.rupees = rupees;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            return ((Employee) obj).employee_id == this.employee_id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", rupees=" + rupees +
                '}';
    }
}
