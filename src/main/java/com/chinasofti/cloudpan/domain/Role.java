package com.chinasofti.cloudpan.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 未实现
 * @author William D X Zheng
 * @date 2018/8/2 22:35
 */
@Entity
@Table(name = "t_role",schema = "couldpan")
public class Role {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    private String name;
}
