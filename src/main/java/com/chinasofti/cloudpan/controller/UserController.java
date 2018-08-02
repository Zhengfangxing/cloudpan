package com.chinasofti.cloudpan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author William D X Zheng
 * @date 2018/8/2 18:11
 */
@Controller
public class UserController {
    @GetMapping("/gouploadimg")
    public String gouploadimg() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        if (file.isEmpty()) {
            return "redirect:uploadStatus";
        }else {
            return "redirect:uploadStatus";
        }

    }




}
