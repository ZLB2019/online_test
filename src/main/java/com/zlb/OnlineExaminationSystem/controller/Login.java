package com.zlb.OnlineExaminationSystem.controller;

import com.zlb.OnlineExaminationSystem.bean.Administrator;
import com.zlb.OnlineExaminationSystem.bean.Results;
import com.zlb.OnlineExaminationSystem.bean.User;
import com.zlb.OnlineExaminationSystem.mapper.AdministratorMapper;
import com.zlb.OnlineExaminationSystem.service.AdministratorService;
import com.zlb.OnlineExaminationSystem.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/login")
public class Login {

    @Autowired
    AdministratorService administratorService;

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello!!!";
    }

    @RequestMapping("/select")
    public Administrator select_id(Integer id){
        return administratorService.selectAdministrator(id);
    }

    @RequestMapping("/judge")
    public int login(User user){
        System.out.println(user);
        System.out.println(DigestUtils.md5Hex(user.getUser_password()));
        Administrator administrator =  administratorService.selectAdministrator(user.getUser_id());
        if(administrator!=null&&administrator.getAdministrator_password().equals(DigestUtils.md5Hex(user.getUser_password()))){
            return 2;
        }

        User user1 = userService.selectUserByUser_id(user.getUser_id());
        /**
         * 如果user1为空，表明id不存在，或者密码不匹配，则登录失败
         */
        if(user1 == null||!user1.getUser_password().equals(DigestUtils.md5Hex(user.getUser_password()))){
            System.out.println("失败");
            return 0;
        }else{
            System.out.println("成功");
            return 1;
        }
    }

//    @RequestMapping("/judge")
//    public int login(User user) {
//        user.setUser_name("ppp");
//        System.out.println(user);
//        userService.insertUser(user);
//        return 1;
//    }
}
