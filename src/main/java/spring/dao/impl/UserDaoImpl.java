package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.UserDao;
import spring.dao.repository.UserRepository;
import spring.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        return userRepository.findById(userId).get();
    }
}
