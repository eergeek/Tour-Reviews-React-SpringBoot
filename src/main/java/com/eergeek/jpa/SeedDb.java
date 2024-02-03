package com.eergeek.jpa;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SeedDb {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * @PostConstruct will initialize after all auto wiring is done
     * It will call this method after jdbcTemplate is initialized.
     */
    @PostConstruct
    void initEmployeeTable() {
        jdbcTemplate.update("insert into EMPLOYEES(name, region, salary) VALUES(?,?,?)",
                new Object[]{"Jack", "US", 1000});
        jdbcTemplate.update("insert into EMPLOYEES(name, region, salary) VALUES(?,?,?)",
                new Object[]{"Jon", "UK", 2000});
        jdbcTemplate.update("insert into EMPLOYEES(name, region, salary) VALUES(?,?,?)",
                new Object[]{"Dion", "UAE", 3000});
        jdbcTemplate.update("insert into EMPLOYEES(name, region, salary) VALUES(?,?,?)",
                new Object[]{"Roni", "UAE", 4000});
        jdbcTemplate.update("insert into EMPLOYEES(name, region, salary) VALUES(?,?,?)",
                new Object[]{"Dion", "UN", 500});    }
}
