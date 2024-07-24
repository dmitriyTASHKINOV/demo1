package com.example.demo1.repo;

import com.example.demo1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserDao extends JpaRepository<User,Long> {
}
