package com.example.Boot.service;

import com.example.Boot.dao.RoleDao;
import com.example.Boot.entity.Role;
import com.example.Boot.entity.User;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> getListRole() {
        return roleDao.getListRole();
    }

    @Override

    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public Role getById(int id) {
        return roleDao.getById(id);
    }

    @Override
    public Role getByName(String roleName) {
        return roleDao.getByName(roleName);
    }

    @Override
    public HashSet getRoleSet(String[] role){
        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(roleDao.getByName(roles));
        }
        return (HashSet) roleSet;
    }
}