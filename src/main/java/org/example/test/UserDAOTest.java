package org.example.test;

import org.example.dao.UserDAO;
import org.example.model.User;
import org.example.database.DatabaseConnection;
import org.example.database.SchemaInitializer;

import java.sql.Connection;

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

            User user2 = new User();
            user2.setId(2);
            user2.setEmail("test2@example.com");
            user2.setName("test2");
            user2.setPassword("test2");
            userDAO.insertUser(user2);


            // test : retrieve user by id
            User retriedUser = userDAO.getUserById(1);
            // System.out.println("Retrieved user: " + retriedUser);

            // test : delete user by id
            System.out.println("Delete user: " + userDAO.getUserById(2));
            userDAO.deleteUserById(2);

            // Test: get all users
            System.out.println("All users: " + userDAO.getAllUsers());

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}
