package com.zlb.OnlineExaminationSystem.controller;

import com.zlb.OnlineExaminationSystem.bean.User;
import com.zlb.OnlineExaminationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class Main {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public User MainShow(Integer user_id){
        User user = userService.selectUserByUser_id(user_id);
        return user;
    }
}
