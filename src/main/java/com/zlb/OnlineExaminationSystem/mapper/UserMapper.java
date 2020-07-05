package com.zlb.OnlineExaminationSystem.mapper;

import com.zlb.OnlineExaminationSystem.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface UserMapper {

    @Insert("INSERT  into user(user_id,user_password,user_name) VALUES(#{user_id},#{user_password},#{user_name})")
    int insertUser(User user);

    @Delete("DELETE from user WHERE user_id = #{user_id}")
    int deleteByUser_id(Integer user_id);

    @Select("select * from user where user_id=#{user_id}")
    User selectUserByUser_id(Integer user_id);

    @Select("select * from user")
    ArrayList<User> selectAllUser();

    @Update("update user set user_password = #{user_password},user_name = #{user_name} where user_id = #{user_id}")
    int updateUser(User user);
}
