package com.example.Boot.dao;

import com.example.Boot.entity.Role;
import com.example.Boot.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;



@Repository
@Transactional(readOnly = true)
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getListRole() {
        return entityManager.createQuery("SELECT  r FROM Role r").getResultList();
    }

    @Transactional
    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Transactional
    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getByName(String roleName) {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT role FROM Role role WHERE role.role = :role", Role.class);
        return query
                .setParameter("role", roleName)
                .getSingleResult();
    }
}
