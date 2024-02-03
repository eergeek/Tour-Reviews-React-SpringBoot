package com.eergeek.jpa.service;

import com.eergeek.jpa.entity.Employee;
import com.eergeek.jpa.EmployeeRepository;
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
        Employee logan = new Employee("Logan Poll", "RUS", 5000);
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
        displayEmployees("***** Employees in UAE ****", UAEEmployees);

        // find salary range 3000 to 10000
        Iterable<Employee> salaryRangeEmployees = repository.findInSalaryRange(3000, 10000);
        displayEmployees("*** Employees Salary between 3000 to 10000 ***", salaryRangeEmployees);

        // get a page of employees from result
        // page no start from 0
        Pageable pageable = PageRequest.of(2, 1, Sort.Direction.DESC,"rupees");
        Iterable<Employee> page2InDescSalary = repository.findByRupeesGreaterThan(600, pageable);
        displayEmployees("*** Page 2 in DESC salary > 600 *** ", page2InDescSalary);
    }
    private void displayEmployees(String message, Iterable<Employee> employees) {
        System.out.println(message);
        employees.forEach(System.out::println);
    }
}
