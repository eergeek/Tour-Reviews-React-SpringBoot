package com.eergeek.datajpa.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    private Scanner scanner = new Scanner(System.in);

    public void queryEmployees() {

        try {
            // get employee count
            long empCount = repository.getEmployeeCount();
            System.out.println("Total Employee Count: " + empCount);

            // get one employee by id
            long id = promptForId("Enter employee id to find: ");
            Employee employee = repository.getEmployee(id);
            System.out.printf("Data for id: %d: %s\n", id, employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private long promptForId(String prompt) {
        System.out.println(prompt);
        long id = scanner.nextLong();
        return id;
    }

    private static void displayEmployees(String operation, EmployeeRepository repository) {
        List<Employee> employees = repository.getEmployees();
        employees.forEach(System.out::println);
    }

    public void modifyEmployeesTable() {
        try {
            // Insert new employee
            Employee terry = new Employee("Terry", "IND", 10000);
            repository.insertEmployee(terry);
            displayEmployees("==== Employees After Insert Operation ", repository);

            // Update Employee Terry
            terry.setRupees(0);
            repository.updateEmployee(terry);
            displayEmployees("==== After UPDATE Operation ", repository);

            // Delete terry
            long id = promptForId("Enter employee id to DELETE: ");
            repository.deleteEmployee(id);
            displayEmployees("=== After DELETE Operation ", repository);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
