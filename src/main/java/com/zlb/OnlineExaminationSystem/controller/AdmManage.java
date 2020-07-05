package com.zlb.OnlineExaminationSystem.controller;

import com.zlb.OnlineExaminationSystem.bean.Results;
import com.zlb.OnlineExaminationSystem.bean.Title;
import com.zlb.OnlineExaminationSystem.bean.User;
import com.zlb.OnlineExaminationSystem.service.ResultsService;
import com.zlb.OnlineExaminationSystem.service.TitleService;
import com.zlb.OnlineExaminationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@ResponseBody
@RequestMapping("/manage")
public class AdmManage {

    @Autowired
    UserService userService;
    @Autowired
    TitleService titleService;
    @Autowired
    ResultsService resultsService;

    @RequestMapping("all_user")
    public ArrayList<User> AllUser(){
        return userService.selectAllUser();
    }

    @RequestMapping("all_title")
    public ArrayList<Title> AllTitle(){
        return titleService.selectAllTitle();
    }

    @RequestMapping("/insert_user")
    private int insertUser(User user){
        if(userService.selectUserByUser_id(user.getUser_id())!=null){
            return 0;
        }else{
            userService.insertUser(user);
            return 1;
        }
    }

    @RequestMapping("/selectUserById")
    public User SelectUserByUser_id(int user_id){
        User user=userService.selectUserByUser_id(user_id);
        if(user==null){
            return null;
        }else{
            return user;
        }
    }

    @RequestMapping("/UpdateUser")
    public void UpdateUser(User user){
        userService.updateUser(user);
    }

    @RequestMapping("/DeleteUser")
    public void DeleteUser(int user_id){
        userService.deleteByUser_id(user_id);
    }

    @RequestMapping("/insert_Title")
    private int  insertTitle(String title_name){
        System.out.println(title_name);
        Title title = new Title();
        title.setTitle_name(title_name);
        titleService.insertTitle(title);
        return title.getTitle_id();
    }

    @RequestMapping("/delete_Title")
    private void deleteTitle(int title_id){
        titleService.deleteByTitle_id(title_id);
    }

    @RequestMapping("/delete_Results")
    private void deleteResults(int title_id){
        resultsService.deleteResultByTitle_id(title_id);
    }

    @RequestMapping("/insert_Results")
    private void insertResults(Results results){
        resultsService.insertResults(results);
    }

    @RequestMapping("/selectTitleById")
    public Title selectTitleById(int title_id){
        Title title = titleService.selectByTitle_id(title_id);
        return title;
    }

    @RequestMapping("/selectResultsByTitle_id")
    public ArrayList<Results> selectResultsByTitle_id(int title_id){
        return resultsService.selectResultByTitle_id(title_id);
    }

    @RequestMapping("updateTitle")
    public void updateTitle(Title title){
        titleService.updateTitle(title);
    }

    @RequestMapping("updateResults")
    public void updateResults(Results results){
        System.out.println(results);
        resultsService.updateResults(results);
    }

    @RequestMapping("deleteResultsByResults_id")
    public void deleteResultsByResults_id(int results_id){
        resultsService.deleteResultByResults_id(results_id);
    }
}
