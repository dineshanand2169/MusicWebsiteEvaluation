package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.UserDao;
import spring.model.User;
import spring.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);

    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        User user1 = getUserById(user.getId());
        user1.setName(user.getName());
        user1.setUserName(user.getUserName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setPhoneNumber(user.getPhoneNumber());
        userDao.updateUser(user1);
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        userDao.deleteUser(userId);

    }

    @Override
    public User getUserById(int userId) throws SQLException {
        return userDao.getUserById(userId);
    }

    @Override
    public User getUpdatedUser(User user) {
        user.setActive(false);
        user.setStatus("Registered");
        userDao.insertUser(user);
        return user;
    }

    @Override
    public User getUserByUserName(String name) {
        return userDao.getUserByUserName(name);
    }

    @Override
    public List<User> getUserByStatus(String status) {
        return userDao.getUserByStatus(status);
    }
}
