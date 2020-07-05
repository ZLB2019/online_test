package com.zlb.OnlineExaminationSystem.service;

import com.zlb.OnlineExaminationSystem.bean.Grade;
import com.zlb.OnlineExaminationSystem.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GradeService implements GradeMapper {

    @Autowired
    GradeMapper gradeMapper;

    @Override
    public int InsertGrade(Grade grade) {
        return gradeMapper.InsertGrade(grade);
    }

    @Override
    public ArrayList<Grade> selectResultByUser_id(Integer user_id) {
        return gradeMapper.selectResultByUser_id(user_id);
    }

    @Override
    public int DeldteByUser_id(Integer user_id) {
        return gradeMapper.DeldteByUser_id(user_id);
    }
}
