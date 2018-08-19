package com.chinasofti.cloudpan.dao;

import com.chinasofti.cloudpan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 未实现
 * @author Charles C Wang
 * @date 2018/8/13 21:52
 */
public interface UserDao extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE LOWER(u.uname)=LOWER(:username) ")
    User findByUsername(@Param("username") String username);
    @Query(value = "SELECT u FROM User u WHERE u.uaccount=?1 AND u.password=?2")
    User findByUsernameAndPassword(String uacount,String uaccount);
}
