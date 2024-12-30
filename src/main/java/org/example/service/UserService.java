package org.example.service;
import java.util.List;
import org.example.model.User;
import org.example.dao.UserDAO;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDao) {
        this.userDAO = userDao;
    }
}
