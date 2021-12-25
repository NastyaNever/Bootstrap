package com.example.Boot.dao;

import com.example.Boot.entity.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getListRole();

    void add(Role role);

    void update(Role role);

    Role getById(int id);

    Role getByName(String roleName);
}