package com.eergeek.datajpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
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

    @Transactional
    void insertEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Transactional
    void updateEmployee(Employee newEmployeeData) {
        Employee employee = entityManager.find(Employee.class, newEmployeeData.getEmployee_id());
        employee.setName(newEmployeeData.getName());
        employee.setRegion(newEmployeeData.getRegion());
        employee.setRupees(newEmployeeData.getRupees());
    }

    @Transactional
    void deleteEmployee(long id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
