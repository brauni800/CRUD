
package com.crud.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBConnect {
    public DriverManagerDataSource connect() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/crud");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        return dataSource;
    }
}
