package com.eergeek.interdependency;

public class DataSource {
    private String connectionString;
    private int maxPoolSize;

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "connectionString='" + connectionString + '\'' +
                ", maxPoolSize=" + maxPoolSize +
                '}';
    }
}
