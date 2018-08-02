package com.chinasofti.cloudpan.domain;

import javax.persistence.*;

/**
 * @author William D X Zheng
 * @date 2018/8/2 17:27
 */
@Entity
@Table(name="t_user",schema = "cloudpan")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column
    private String uname;

    @Column
    private String uaccount;

    @Column
    private String password;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
