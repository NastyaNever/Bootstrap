package com.example.Boot.dao;


import com.example.Boot.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT  u FROM User u JOIN FETCH u.roles", User.class).getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public User show(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void removeUserById(long id) {
        entityManager.remove(show(id));
    }

    @Override
    public User findByUserName(String name) {
        return entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.roles WHERE u.name=:name", User.class).setParameter("name", name).getSingleResult();

    }
}