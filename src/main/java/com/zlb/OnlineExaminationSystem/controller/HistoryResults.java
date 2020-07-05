package com.zlb.OnlineExaminationSystem.controller;

import com.zlb.OnlineExaminationSystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@ResponseBody
@RequestMapping("/history_res")
public class HistoryResults {
    @Autowired
    GradeService gradeService;

    @RequestMapping("/resList")
    public ArrayList resList(int user_id){
        ArrayList resList = gradeService.selectResultByUser_id(user_id);
        System.out.println(resList);
        return resList;
    }
}
