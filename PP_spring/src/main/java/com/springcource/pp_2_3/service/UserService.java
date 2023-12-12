package com.springcource.pp_2_3.service;

import com.springcource.pp_2_3.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void removeUser(int id);

}