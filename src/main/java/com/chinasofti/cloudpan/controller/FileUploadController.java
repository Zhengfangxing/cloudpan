package com.chinasofti.cloudpan.controller;

import com.chinasofti.cloudpan.domain.Product;
import com.chinasofti.cloudpan.domain.Result;
import com.chinasofti.cloudpan.service.IboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

/**
 * @author William D X Zheng
 * @date 2018/8/4 15:28
 */
@Controller
public class FileUploadController {
    @Autowired
    private IboxService iboxService;

    @GetMapping("/")
    public String index(){
        return "upload";
    }
    @PostMapping("/upload")
    public String upload(MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        Result result = Result.error();
        if (file.isEmpty()) {

            result = new Result(301,"请选择一个文件上传",null);
        }else {
            try {
                iboxService.upload(file);
                result = new Result(200,"文件:"+file.getOriginalFilename()+"上传成功",null);
            } catch (Exception e) {
                e.printStackTrace();
                result = new Result(300,"文件上传失败请联系管理员",null);
            }
        }
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @GetMapping("/select")
    public String findAll(RedirectAttributes redirectAttributes){
        List<Product> list = iboxService.findAll();
        redirectAttributes.addFlashAttribute("list",list);
        return "redirect:/details";
    }
    @GetMapping("details")
    public String details(){
        return "details";
    }

    /**
     * @author Charles C Wang
     * @date 2018/8/13 23:46
     * @return Result
     */
    @PostMapping("/list")
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
    @GetMapping("delete")
    public Result delete(Integer id){
        boolean flag = iboxService.delFile(id);
        Result result = Result.error();
        if(flag){
            result = Result.success();
        }

        return result;
    }

//    @DeleteMapping("delete/{pid}")
}
