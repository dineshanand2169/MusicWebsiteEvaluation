package spring.service;

import spring.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void insertUser(User user);

    List<User> getAllUser();

    void updateUser(User user) throws SQLException;

    void deleteUser(int userId) throws SQLException;

    User getUserById(int userId) throws SQLException;
    User getUpdatedUser(User user);
    User getUserByUserName( String name);
    List<User> getUserByStatus(String status);
}
