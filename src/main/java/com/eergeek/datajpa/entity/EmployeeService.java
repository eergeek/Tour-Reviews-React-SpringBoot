package com.eergeek.datajpa.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            long id = promptForId();
            Employee employee = repository.getEmployee(id);
            System.out.printf("Data for id: %d: %s\n", id, employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private long promptForId() {
        System.out.println("Enter employee id to find: ");
        long id = scanner.nextLong();
        return id;
    }

}
