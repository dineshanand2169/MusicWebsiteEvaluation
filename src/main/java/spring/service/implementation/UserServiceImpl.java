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
    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        userDao.deleteUser(userId);

    }

    @Override
    public User getUserById(int userId) throws SQLException {
        return userDao.getUserById(userId);
    }
}
