package com.springcource.pp_2_3.service;

import com.springcource.pp_2_3.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void persistUser(User user);

    User getUser(int id);

    void removeUser(int id);

}