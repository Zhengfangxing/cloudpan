package com.chinasofti.cloudpan.service;

import com.chinasofti.cloudpan.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */
public interface IUserService {
    public User Login(String acount, String password);

    public User add(User user);

    public List<User> list();
}
