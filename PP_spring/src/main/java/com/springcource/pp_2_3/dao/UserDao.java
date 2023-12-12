package com.springcource.pp_2_3.dao;

import com.springcource.pp_2_3.model.User;
import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(int id);
    public void removeUser(int id);

}
