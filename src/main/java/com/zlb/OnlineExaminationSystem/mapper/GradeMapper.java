package com.zlb.OnlineExaminationSystem.mapper;

import com.zlb.OnlineExaminationSystem.bean.Grade;
import com.zlb.OnlineExaminationSystem.bean.Results;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface GradeMapper {

    @Insert("insert into grade(user_id,user_grade,time) values(#{user_id},#{user_grade},#{time})")
    int InsertGrade(Grade grade);

    @Delete("DELETE from grade WHERE user_id = #{user_id}")
    int DeldteByUser_id(Integer user_id);

    @Select("select * from grade where user_id=#{user_id}")
    ArrayList<Grade> selectResultByUser_id(Integer user_id);
}
