package com.chinasofti.cloudpan.controller;

import com.chinasofti.cloudpan.domain.Product;
import com.chinasofti.cloudpan.domain.Result;
import com.chinasofti.cloudpan.service.IboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */
@RestController
@RequestMapping("/file")
public class fileManagerControler {
    @Autowired
    private IboxService iboxService;

    /**
     * @author Charles C Wang
     * @date 2018/8/13 23:46
     * @return Result
     */
    @RequestMapping("/list")
    public Result list(){
        Result result = Result.error();
        List<Product> list = iboxService.findAll();
        if(list.size()>=0){
            result = new Result(200,"查询列表成功！",list);
        }

        return result;
    }


    /**
     * @author Charles C Wang
     * @date 2018/8/13 21:15
     * @return Result
     */
    @RequestMapping("delete")
    public Result delete(Integer id){
        boolean flag = iboxService.delFile(id);
        Result result = Result.error();
        if(flag){
            result = Result.success();
        }

        return result;
    }
    /**
     * @author Charles C Wang
     * @date 2018/8/13 21:15
     * @return Result
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        Result result = Result.error();
        System.out.println("file:"+file);
        if (file.isEmpty()) {

            result = new Result(301,"请选择一个文件上传",null);
         }else {
            try {

                iboxService.upload(file);
                result = new Result(200,"文件:"+file.getOriginalFilename()+"上传成功",null);
            } catch (Exception e) {
                result = new Result(300,"文件上传失败请联系管理员",null);
            }
         }

        return result;
    }
}
