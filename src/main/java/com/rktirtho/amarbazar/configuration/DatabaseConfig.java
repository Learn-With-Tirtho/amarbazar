package com.rktirtho.amarbazar.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfig {
    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/amarbazar";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";
    private static final String MAX_POOL = "250";
    private static Connection connection = null;

    private Properties properties;

    // create properties
    private Properties getProperties() {
        if(properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }


    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = (Connection) DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        DatabaseConfig databaseConfig = new DatabaseConfig();

        System.out.println(databaseConfig.connect());
    }
}
