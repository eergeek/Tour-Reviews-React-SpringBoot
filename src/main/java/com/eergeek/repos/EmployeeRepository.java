package com.eergeek.repos;

import com.eergeek.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByRegion(String region);

    @Query("select emp from Employee emp where emp.rupees >= ?1 and emp.rupees <= ?2")
    List<Employee> findInSalaryRange(int from, int to);

    Page<Employee> findByRupeesGreaterThan(double salary, Pageable pageable);
}
