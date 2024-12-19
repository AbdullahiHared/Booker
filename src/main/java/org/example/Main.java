package org.example;
import org.example.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
       if (connection != null) {
            System.out.println("Connection established successfully");
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to establish connection");
        }
    }
}