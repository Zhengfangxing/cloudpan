package com.chinasofti.cloudpan.controller;

import com.chinasofti.cloudpan.domain.Product;
import com.chinasofti.cloudpan.domain.Result;
import com.chinasofti.cloudpan.service.IboxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Songchao on 2018/8/19.
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileManagerControler {
    @Autowired
    private IboxService iboxService;

    /**
     * @return Result
     * @author Charles C Wang
     * @date 2018/8/13 23:46
     */
    @RequestMapping("/list")
    public Result list() {
        Result result = Result.error();
        List<Product> list = iboxService.findAll();
        if (list.isEmpty()) {
            result = new Result(200, "查询列表成功！", list);
        }

        return result;
    }


    /**
     * @return Result
     * @authorSongchao 宋超
     * @date 2018/8/13 21:15
     */
    @RequestMapping("delete")
    public Result delete(Integer id) {
        boolean flag = iboxService.delFile(id);
        Result result = Result.error();
        if (flag) {
            result = Result.success();
        }

        return result;
    }

    /**
     * @return Result
     * @author Charles C Wang
     * @date 2018/8/13 21:15
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        Result result = Result.error();
        log.info("file:" + file);
        if (file.isEmpty()) {

            result = new Result(301, "请选择一个文件上传", null);
        } else {
            try {

                iboxService.upload(file);
                result = new Result(200, "文件:" + file.getOriginalFilename() + "上传成功", null);
            } catch (Exception e) {
                result = new Result(300, "文件上传失败请联系管理员", null);
            }
        }

        return result;
    }
}
