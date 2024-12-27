package org.example.database;

import java.sql.Connection;
import java.sql.Statement;

public class SchemaInitializer {
    public static void initializeSchema(Connection connection) {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS buses (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(255) NOT NULL,
                    route VARCHAR(255) NOT NULL,
                    capacity INT NOT NULL
                )
                
                CREATE TABLE IF NOT EXISTS booking (
                    id INT PRINTARY KEY AUTO_INCREMENT,
                    bus_id INT NOT NULL,
                    passenger_name VARCHAR(255) NOT NULL,
                    booking_date DATE NOT NULL,
                    FOREIGN KEY (bus_id) REFERENCES buses(id)
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
