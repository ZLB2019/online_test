package com.zlb.OnlineExaminationSystem.mapper;

import com.zlb.OnlineExaminationSystem.bean.Results;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface ResultsMapper {

    @Insert("insert into results(title_id,results_name,is_correct) values(#{title_id},#{results_name},#{is_correct})")
    int insertResults(Results results);

    @Delete("DELETE from results WHERE title_id = #{title_id}")
    int deleteResultByTitle_id(Integer title_id);

    @Delete("DELETE from results WHERE results_id = #{results_id}")
    int deleteResultByResults_id(Integer results_id);

    @Select("select * from results where title_id=#{title_id}")
    ArrayList<Results> selectResultByTitle_id(Integer title_id);

    @Update("update results set results_name = #{results_name},is_correct = #{is_correct},title_id = #{title_id} where results_id = #{results_id}")
    int updateResults(Results results);
}
