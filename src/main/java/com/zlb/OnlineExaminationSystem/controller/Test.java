package com.zlb.OnlineExaminationSystem.controller;

import com.zlb.OnlineExaminationSystem.uuuu.ReturnTime;
import com.zlb.OnlineExaminationSystem.bean.Grade;
import com.zlb.OnlineExaminationSystem.bean.TestAll;
import com.zlb.OnlineExaminationSystem.bean.Title;
import com.zlb.OnlineExaminationSystem.bean.WrongTitle;
import com.zlb.OnlineExaminationSystem.service.GradeService;
import com.zlb.OnlineExaminationSystem.service.ResultsService;
import com.zlb.OnlineExaminationSystem.service.TitleService;
import com.zlb.OnlineExaminationSystem.service.WrongTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
@Controller
@ResponseBody
@RequestMapping("/test")
public class Test {

    private final Integer number = 10;

    @Autowired
    TitleService titleService;
    @Autowired
    ResultsService resultsService;
    @Autowired
    GradeService gradeService;
    @Autowired
    WrongTitleService wrongTitleService;


    @RequestMapping("/simulation")
    public ArrayList<TestAll> test(){
        ArrayList<TestAll> testAllList = new ArrayList();
        ArrayList<Title> titleArraylist =  titleService.selectRandomTitle(number);
        for(int i = 0 ;i<titleArraylist.size();i++){
            TestAll testAll = new TestAll();
            testAll.setTitle((Title)titleArraylist.get(i));
            testAll.setResultsArrayList(resultsService.selectResultByTitle_id(testAll.getTitle().getTitle_id()));
            testAllList.add(testAll);
        }
        return testAllList;
    }

    @RequestMapping("/submitGrade")
    public void submitGrade(int user_id,int res, HttpSession session){
        Grade grade = new Grade();
        grade.setUser_grade(res);
        grade.setUser_id(user_id);
        grade.setTime(ReturnTime.ReturnNoTime());
        System.out.println(grade);
        gradeService.InsertGrade(grade);
    }

    @RequestMapping("/errorTitle")
    private void errorTitle(WrongTitle wrongTitle){
        if(wrongTitleService.selectWrongTitle(wrongTitle)==null)
            wrongTitleService.InsertWrongTitle(wrongTitle);
    }

}
