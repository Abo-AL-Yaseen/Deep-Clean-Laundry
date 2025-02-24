package com.example.project_db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    public Connection connection;

    public Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String DBuser = "postgres", DBname = "root";

        try {
            connection = DriverManager.getConnection(url,DBuser,DBname);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
