package com.springcource.pp_2_3.dao;

import com.springcource.pp_2_3.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void updateUser(User user);

    void persistUser(User user);

    User getUser(int id);

    void removeUser(int id);

}
