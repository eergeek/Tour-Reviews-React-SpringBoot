package com.eergeek.jpa.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId = -1;
    private String name;
    private String region;

    @Column(name = "salary")
    private int rupees;

    public Employee() {
    }

    public Employee(String name, String region, int rupees) {
        this.name = name;
        this.region = region;
        this.rupees = rupees;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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

    public int getRupees() {
        return rupees;
    }

    public void setRupees(int rupees) {
        this.rupees = rupees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", rupees=" + rupees +
                '}';
    }
}
