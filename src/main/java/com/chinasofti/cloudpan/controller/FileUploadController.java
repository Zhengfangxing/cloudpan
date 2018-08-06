package com.chinasofti.cloudpan.controller;

import com.chinasofti.cloudpan.domain.Product;
import com.chinasofti.cloudpan.domain.Result;
import com.chinasofti.cloudpan.service.IboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        Result result = new Result();
        if (file.isEmpty()) {
            result.setMessage("请选择一个文件上传");
            result.setStatus(false);
        }else {
            try {
                iboxService.upload(file);
                result.setMessage("文件:"+file.getOriginalFilename()+"上传成功");
                result.setStatus(true);
            } catch (Exception e) {
                e.printStackTrace();
                result.setMessage("文件上传失败请联系管理员");
                result.setStatus(false);
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

//    @DeleteMapping("delete/{pid}")
}
