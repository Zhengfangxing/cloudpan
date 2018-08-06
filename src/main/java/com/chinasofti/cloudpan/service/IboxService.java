package com.chinasofti.cloudpan.service;

import com.chinasofti.cloudpan.domain.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * 文件接口
 * @author William D X Zheng
 * @date 2018/8/7 0:55
 */
public interface IboxService {
    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    void upload(MultipartFile file) throws IOException;

    /**
     * 查询文件
     *
     * @return
     */
    List<Product> findAll();

    /**
     * 通过ID查询
     *
     * @param pid
     * @return
     */
    Optional<Product> findById(Integer pid);

    /**
     * 通过ID删除文件
     * @param pid
     */
    void delFile(Integer pid);
}
