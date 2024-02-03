package com.eergeek.mongo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

public class Employee {

    @Id
    private long employeeId;
    private String name;
    private String region;

    @Field("salary")
    private double rupees;

    public Employee() {
    }

    public Employee(long employeeId, String name, String region, int rupees) {
        this.employeeId = employeeId;
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

    public double getRupees() {
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

