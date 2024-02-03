package com.eergeek.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {


    @Autowired
    EmployeeRepository repository;

    public void useStandardCRUDRepoMethods() {
        // insert new employee
        Employee logan = new Employee(SequenceGenerator.getNextId(), "Logan Poll", "RUS", 5000);
        logan = repository.save(logan);
        System.out.println("+++++++ INSERT LOGAN new ID: " + logan.getEmployeeId());

        // get all employee count
        long count = repository.count();
        System.out.println("==== Total Count: " + count);

        // get all employees
        displayEmployees("==== Get All Employees ====", repository.findAll());

    }

    public void useCustomCRUDRepoMethods() {
        // get all employees by region
        Iterable<Employee> UAEEmployees = repository.findByRegion("UAE");
        displayEmployees("\n***** Employees in UAE ****", UAEEmployees);

        // find salary range 3000 to 10000
        Iterable<Employee> salaryRangeEmployees = repository.findEmployeesSalaryInRange(6000, 10000);
        displayEmployees("\n*** Employees Salary between 6000 to 10000 ***", salaryRangeEmployees);

        // get a page of employees from result
        // page no start from 0
        // 1 item per page
        Pageable pageable = PageRequest.of(3, 2, Sort.Direction.DESC,"rupees");
        Iterable<Employee> page2InDescSalary = repository.findByRupeesGreaterThan(600, pageable);
        displayEmployees("\n*** Page 3 (Page size is 2 entries) in DESC salary > 600 *** ", page2InDescSalary);
    }
    private void displayEmployees(String message, Iterable<Employee> employees) {
        System.out.println(message);
        employees.forEach(System.out::println);
    }

}
