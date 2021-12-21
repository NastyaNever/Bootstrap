package com.example.Boot.service;


import com.example.Boot.entity.Role;
import com.example.Boot.entity.User;

import java.util.HashSet;
import java.util.List;

public interface RoleService {

    List<User> getListRole();

    void add(Role role);

    void update(Role role);

    Role getById(int id);

    Role getByName(String roleName);

    public HashSet getRoleSet(String[] role);
}