package com.springcource.pp_2_3.dao;

import com.springcource.pp_2_3.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    private List<User> users = new ArrayList<>();
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return users = entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void removeUser(int id){
        entityManager.remove(entityManager.find(User.class, id));
    }

}


