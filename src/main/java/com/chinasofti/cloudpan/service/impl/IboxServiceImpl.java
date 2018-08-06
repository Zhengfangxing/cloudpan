package com.chinasofti.cloudpan.service.impl;

import com.chinasofti.cloudpan.dao.IboxDao;
import com.chinasofti.cloudpan.domain.Product;
import com.chinasofti.cloudpan.service.IboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 文件实现类
 * @author William D X Zheng
 * @date 2018/8/7 1:00
 */
@Service
@Transactional(rollbackForClassName = "MultipartException.class")
public class IboxServiceImpl implements IboxService {
    @Autowired
    private IboxDao iboxDao;

    @Override
    public void upload(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(file.getOriginalFilename());
        Files.write(path, bytes);
        Product product = new Product();
        product.setFileName(file.getOriginalFilename());
        product.setUploadDate(new Date());
        iboxDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = iboxDao.findAll();
        return list;
    }

    @Override
    public Optional<Product> findById(Integer pid) {
        return Optional.empty();
    }

    @Override
    public void delFile(Integer pid) {

    }
}
