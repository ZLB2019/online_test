package com.zlb.OnlineExaminationSystem.mapper;

import com.zlb.OnlineExaminationSystem.bean.WrongTitle;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface WrongTitleMapper {

    @Insert("insert into wrong_topic(user_id,title_id) values(#{user_id},#{title_id})")
    int InsertWrongTitle(WrongTitle wrongTitle);

    @Delete("DELETE from wrong_topic WHERE user_id = #{user_id} and title_id=#{title_id}")
    int DeldteWrongTitle(WrongTitle wrongTitle);

    @Select("select * from wrong_topic where user_id=#{user_id}")
    ArrayList<WrongTitle> selectWrongTitleByUser_id(Integer user_id);

    @Select("select * from wrong_topic where user_id=#{user_id} and title_id=#{title_id}")
    WrongTitle selectWrongTitle(WrongTitle wrongTitle);
}
