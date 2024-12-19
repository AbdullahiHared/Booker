package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseConnection {
    private static final String URL = "jdbc:h2:mem:busbookingdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void initializeSchema() {
        String schemaPath = "src/sql/schema.sql"; // Adjust path if needed

        try (Connection conn = getConnection();
             BufferedReader br = new BufferedReader(new FileReader(schemaPath))) {

            StringBuilder schemaSql = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                schemaSql.append(line).append("\n");
            }

            try (Statement stmt = conn.createStatement()) {
                stmt.execute(schemaSql.toString());
                System.out.println("Database schema initialized successfully.");
            }

        } catch (IOException e) {
            System.err.println("Error reading schema file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error initializing database schema: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        initializeSchema();
    }

}
