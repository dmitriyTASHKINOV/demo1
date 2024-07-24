package com.example.demo1.Service;

import com.example.demo1.Model.User;
import com.example.demo1.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    public void addUser(User user) {
        userDao.save(user); }

    public void updateUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
