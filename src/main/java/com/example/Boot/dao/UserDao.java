package com.example.Boot.dao;

import com.example.Boot.entity.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void updateUser(User user);

    User show(long id);

    void removeUserById(long id);

    List<User> getAllUsers();

    User findByUserEmail(String email);

    User findByUserName(String name);
}