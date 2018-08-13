package com.chinasofti.cloudpan.service.impl;

import com.chinasofti.cloudpan.dao.UserDao;
import com.chinasofti.cloudpan.domain.User;
import com.chinasofti.cloudpan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User Login(String acount, String password) {

        return this.userDao.findByUsernameAndPassword(acount,password);
    }

    @Override
    public User add(User user) {


        return this.userDao.save(user);
    }

    @Override
    public List<User> list() {
        return this.userDao.findAll();
    }
}
