package com.caihua.service;

import com.caihua.bean.User;
import com.caihua.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delUser(int id) {
        userMapper.delUser(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<User> findUsers(String name) {
        return userMapper.findUsers(name);
    }

    @Override
    public User findUser(int id) {
        return userMapper.findUser(id);
    }
}
