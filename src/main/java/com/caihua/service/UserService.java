package com.caihua.service;

import com.caihua.bean.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public void delUser(int id);

    public void updateUser(User user);

    public List<User> findUsers(String name);

    public User findUser(int id);
}
