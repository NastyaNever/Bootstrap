package com.example.Boot.service;


import com.example.Boot.entity.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleService {

    List<Role> getListRole();

    void add(Role role);

    void update(Role role);

    Role getById(int id);

    Role getByName(String roleName);

    public HashSet getRoleSet(String[] role);
}