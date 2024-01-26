package com.eergeek.interdependency;

public class TransactionManager {
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    void beginTransaction() {
        System.out.println("Begin transaction on datasource " + dataSource);
    }
    void endTransaction() {
        System.out.println("End transaction on datasource " + dataSource);
    }
}
