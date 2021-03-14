package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {

    public List<User> index();

    public void save(User user);

    public User show(int id);

    public void delete(int id);

    public void update(int id, User updatedUser);
}
