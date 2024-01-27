package com.eergeek.datajpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;
    long getEmployeeCount() {
        String jpql = "select count(e) from Employee e";
        TypedQuery<Long> typedQuery = entityManager.createQuery(jpql, Long.class);
        Long empCount = typedQuery.getSingleResult();

        return empCount;
    }

    Employee getEmployee(long empId) {
        return entityManager.find(Employee.class, empId);
    }

    List<Employee> getEmployees() {
        String jpql = "select e from Employee e";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(jpql, Employee.class);
        return typedQuery.getResultList();
    }
}
