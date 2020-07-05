package com.zlb.OnlineExaminationSystem.mapper;

import com.zlb.OnlineExaminationSystem.bean.Title;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
public interface TitleMapper {

    @Insert("insert into title(title_name) values(#{title_name})")
    @Options(useGeneratedKeys=true, keyProperty="title_id", keyColumn="title_id")
    int insertTitle(Title title);

    @Delete("DELETE from title WHERE title_id = #{title_id}")
    int deleteByTitle_id(Integer title_id);

    @Select("select * from title where title_id=#{title_id}")
    Title selectByTitle_id(Integer title_id);

    @Select("select * from title")
    ArrayList<Title> selectAllTitle();

    @Select("SELECT * FROM title  ORDER BY RAND() LIMIT #{number}")
    ArrayList<Title> selectRandomTitle(Integer number);

    @Update("update title set title_name = #{title_name} where title_id = #{title_id}")
    int updateTitle(Title title);
}
