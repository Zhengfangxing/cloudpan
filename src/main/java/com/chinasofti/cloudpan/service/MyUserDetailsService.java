package com.chinasofti.cloudpan.service;

import com.chinasofti.cloudpan.dao.UserDao;
import com.chinasofti.cloudpan.domain.Role;
import com.chinasofti.cloudpan.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author William D X Zheng
 * @date 2018/8/2 19:05
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String loginUserName) throws UsernameNotFoundException {
        String username = loginUserName.toLowerCase();
        User userFromDatabase = userDao.findByUsername(username);
        if (userFromDatabase == null) {
            throw new UsernameNotFoundException("User" + username + "不存在");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : userFromDatabase.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(
                userFromDatabase.getUname(),
                userFromDatabase.getPassword(),
                authorities);
    }
}
