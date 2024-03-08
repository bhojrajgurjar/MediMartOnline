package com.pharmacystore.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getDatabaseConnection() {
        try {
            Class.forName(DbDetails.DBDRIVER);

            Connection con = DriverManager.getConnection(
                    DbDetails.CONSTR,
                    DbDetails.USERNAME,
                    DbDetails.PASSWORD);

            return con;

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}