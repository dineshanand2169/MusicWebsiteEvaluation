package spring.dao;

import org.springframework.data.repository.query.Param;
import spring.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void insertUser(User user);

    List<User> getAllUser();

    void updateUser(User user);

    void deleteUser(int userId) throws SQLException;

    User getUserById(int userId) throws SQLException;
    User getUserByUserName( String name);
    List<User> getUserByStatus(String status);
}
