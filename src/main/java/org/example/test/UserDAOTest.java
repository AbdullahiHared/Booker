package org.example.test;

import org.example.dao.UserDAO;
import org.example.model.User;
import org.example.database.DatabaseConnection;
import org.example.database.SchemaInitializer;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDAOTest {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Initialize the schema
            SchemaInitializer.initializeSchema(connection);

            // create userDAO instance
            UserDAO userDAO = new UserDAO(connection);

            // Test: add user
            User user = new User();
            user.setId(1);
            user.setEmail("test1@example.com");
            user.setName("test1");
            user.setPassword("test1");
            userDAO.insertUser(user);


            // test : retrieve user by id
            User retriedUser = userDAO.getUserById(1);
            System.out.println("Retrieved user: " + retriedUser);


        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
