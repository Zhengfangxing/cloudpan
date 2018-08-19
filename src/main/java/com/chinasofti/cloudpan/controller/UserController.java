package com.chinasofti.cloudpan.controller;

import com.chinasofti.cloudpan.domain.Result;
import com.chinasofti.cloudpan.domain.User;
import com.chinasofti.cloudpan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public Result login(String acount,String password){
        Result result = Result.error();
        System.out.println("acount:"+acount);
        System.out.println("password:"+password);
        if(acount!=null&&password!=null){
            User user = userService.Login(acount, password);
            if(user!=null){
                result = new Result(200,"登陆成功！",user);
            }

        }

        return result;
    }

    @RequestMapping("/registerUser")
    public Result registerUser(User user){
        Result result = Result.error();
        if(user!=null){
            User user1 = userService.add(user);
            if(user!=null){
                result = new Result(200,"注册成功！",user1);
            }

        }

        return result;
    }

    @RequestMapping("/list")
    public Result list(User user){
        Result result = Result.error();
        if(user!=null){
            List<User> list = userService.list();
            if(list.size()>=0){
                result = new Result(200,"查询成功！",list);
            }

        }

        return result;
    }
}
