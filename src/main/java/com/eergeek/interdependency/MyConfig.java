package com.eergeek.interdependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.xml.crypto.Data;

@Configuration
public class MyConfig {

    @Bean
    DataSource dataSource() {
        System.out.println("======= Creating DataSource Bean ======");
        DataSource dataSource = new DataSource();
        dataSource.setConnectionString("jdbc::/mysql:chou:pwd:1900");
        dataSource.setMaxPoolSize(15);
        return dataSource;
    }
//    @Bean
//    @Primary
//    DataSource dataSourceCopy() {
//        System.out.println("======= Creating DataSource Bean ======");
//        DataSource dataSource = new DataSource();
//        dataSource.setConnectionString("jdbc::nosql:mongodb");
//        dataSource.setMaxPoolSize(20);
//        return dataSource;
//    }

    @Bean
    TransactionManager transactionManager1() {
        System.out.println("======= First Transaction Manager Bean Creating ======");
        TransactionManager txm = new TransactionManager();
        txm.setDataSource(dataSource());

        return txm;
    }

    @Bean
    TransactionManager transactionManager2() {
        System.out.println("====== Second Transaction Manager Bean Creating ======");
        TransactionManager txm = new TransactionManager();
        txm.setDataSource(dataSource());
        return txm;
    }

    // Spring will inject dataSource() bean as "ds" in here
    // Uncomment above dataSourceCopy() to inject another bean
    @Bean
    TransactionManager transactionManager3(DataSource ds) {
        System.out.println("===== Third Transaction Manager Bean Creating =====");
        TransactionManager txm = new TransactionManager();
        txm.setDataSource(ds);
        return txm;
    }
}
