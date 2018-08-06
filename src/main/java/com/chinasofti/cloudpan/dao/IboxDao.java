package com.chinasofti.cloudpan.dao;

import com.chinasofti.cloudpan.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author William D X Zheng
 * @date 2018/8/7 1:02
 */
public interface IboxDao extends JpaRepository<Product,Integer> {
}
