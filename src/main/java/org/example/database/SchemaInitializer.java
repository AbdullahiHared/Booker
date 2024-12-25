package org.example.database;

import java.sql.Connection;
import java.sql.Statement;

public class SchemaInitializer {
    public static void initializeSchema(Connection connection) {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS BUSES (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                route VARCHAR(100) NOT NULL,
                capacity INT NOT NULL
            )
            """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Database schema initialized successfully.");
        } catch (Exception e) {
            System.err.println("Error initializing database schema: " + e.getMessage());
        }
    }
}
