package com.example.demo1.Service;

import com.example.demo1.Model.User;
import com.example.demo1.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImp implements UserService1{
    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> allUser() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> userId(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUserId(Long id) {
    userDao.deleteById(id);
    }
}
