package com.example.demo1.Service;

import com.example.demo1.Model.User;
import com.example.demo1.repo.UserDao;

import java.util.List;
import java.util.Optional;

public interface UserService1  {
    List<User> allUser();
    Optional<User> userId(Long id);
    User saveUser(User user);
    void deleteUserId(Long id);
}
