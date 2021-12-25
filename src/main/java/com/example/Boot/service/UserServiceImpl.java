package com.example.Boot.service;

import com.example.Boot.dao.UserDaoImpl;
import com.example.Boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Bean
    private BCryptPasswordEncoder bCrypt() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCrypt().encode(user.getPassword()));
        userDaoImpl.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDaoImpl.updateUser(user);
    }

    @Override
    public User show(long id) {
        return userDaoImpl.show(id);
    }

    @Override
    public void removeUserById(long id) {
        userDaoImpl.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoImpl.getAllUsers();
    }

    @Override
    public User findByUserName(String name) {
        return userDaoImpl.findByUserName(name);
    }

    @Override
    public User findByUserEmail(String email) {
        return userDaoImpl.findByUserEmail(email);
    }
}