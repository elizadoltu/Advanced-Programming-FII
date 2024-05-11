package com.lab8;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;


public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/books";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static final ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
    }

    private Database() {}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
