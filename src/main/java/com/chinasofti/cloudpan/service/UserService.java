package com.chinasofti.cloudpan.service;

import com.chinasofti.cloudpan.domain.User;

import java.util.Optional;

/**
 * @author William D X Zheng
 * @date 2018/8/2 19:10
 */
public interface UserService {
    Optional<User> findOne(User user);
}
