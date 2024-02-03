package com.eergeek.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {

    List<Employee> findByRegion(String region);

    @Query("""
            {
            'rupees' : {
                    $gte: ?0,
                    $lte: ?1
                }
            }
            """)
    List<Employee> findEmployeesSalaryInRange(double fromSalary, double toSalary);

    /***
     *
     * @param salary
     * @param pageable
     * @return The Result is returned into pages which is customizable in implementation
     */
    @Query("""
            {
                'rupees': { $gte: ?0 }
            }
            """)
    Page<Employee> findByRupeesGreaterThan(double salary, Pageable pageable);
}
