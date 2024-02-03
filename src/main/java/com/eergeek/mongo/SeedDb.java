package com.eergeek.mongo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedDb {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostConstruct
    public void initMongoCollection() {
        System.out.println("++++++++++ Initializing the MONGODB repo with dummy data +++++++++++++");
        try {
            List<Employee> employeeList = List.of(
                    new Employee(SequenceGenerator.getNextId(),"John","US",1000),
                    new Employee(SequenceGenerator.getNextId(),"Jerry", "US", 2000),
                    new Employee(SequenceGenerator.getNextId(),"Tom", "UK", 8000),
                    new Employee(SequenceGenerator.getNextId(),"Tooke", "UK", 1000),
                    new Employee(SequenceGenerator.getNextId(),"Tora", "UAE", 10000),
                    new Employee(SequenceGenerator.getNextId(),"Ahoy", "UAE", 9000)
            );


            employeeRepository.saveAll(employeeList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /***
     * This will remove all data from mongo db before killing the application
     */
    @PreDestroy
    public void cleanMongoCollection() {
        employeeRepository.deleteAll();
    }
}
