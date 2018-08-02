package com.chinasofti.cloudpan.dao;

import com.chinasofti.cloudpan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author William D X Zheng
 * @date 2018/8/2 19:14
 */
public interface UserDao extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE LOWER(u.uname)=LOWER(:username) ")
    User findByUsername(@Param("username") String username);
}
