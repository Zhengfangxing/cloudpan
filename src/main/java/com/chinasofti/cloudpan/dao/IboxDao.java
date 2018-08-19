package com.chinasofti.cloudpan.dao;

import com.chinasofti.cloudpan.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author William D X Zheng
 * @date 2018/8/7 1:02
 */

public interface IboxDao extends JpaRepository<Product,Integer> {
    @Override
    Product getOne(Integer integer);
}
