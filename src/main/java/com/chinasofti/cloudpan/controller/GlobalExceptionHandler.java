package com.chinasofti.cloudpan.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 未实现
 * @author William D X Zheng
 * @date 2018/8/7 0:50
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MultipartException.class)
    public String handleError(MultipartException e, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "redirect:/uploadStatus";
    }
}
