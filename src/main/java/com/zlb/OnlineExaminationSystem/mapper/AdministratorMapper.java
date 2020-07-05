package com.zlb.OnlineExaminationSystem.mapper;

import com.zlb.OnlineExaminationSystem.bean.Administrator;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdministratorMapper {

    @Select("select * from administrator where administrator_id=#{administrator_id}")
    Administrator selectAdministrator(Integer administrator_id);

    @Insert("INSERT  INTO administrator(administrator_id,administrator_password) VALUES(#{administrator_id},#{administrator_password})")
    int insertAdministrator(Administrator administrator);

    @Delete("DELETE FROM administrator WHERE administrator_id = #{administrator_id}")
    int deleteByAdministrator_id(Integer administrator_id);

    @Update(" update administrator set administrator_password = #{administrator_password} where administrator_id = #{administrator_id}")
    int updateAdministrator(Administrator administrator);
}
