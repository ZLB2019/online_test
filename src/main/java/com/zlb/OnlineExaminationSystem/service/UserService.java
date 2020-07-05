package com.zlb.OnlineExaminationSystem.service;

import com.zlb.OnlineExaminationSystem.bean.User;
import com.zlb.OnlineExaminationSystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserMapper{

    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteByUser_id(Integer user_id) {
        return userMapper.deleteByUser_id(user_id);
    }

    @Override
    public ArrayList<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User selectUserByUser_id(Integer user_id) {
        return userMapper.selectUserByUser_id(user_id);
    }
}
