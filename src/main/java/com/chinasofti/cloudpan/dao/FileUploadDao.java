package com.chinasofti.cloudpan.dao;

import com.chinasofti.cloudpan.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author William D X Zheng
 * @date 2018/8/2 17:43
 */
public interface FileUploadDao extends JpaRepository<File,Integer> {
}
