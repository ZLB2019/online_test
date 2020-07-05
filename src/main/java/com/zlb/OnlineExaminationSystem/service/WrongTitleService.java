package com.zlb.OnlineExaminationSystem.service;

import com.zlb.OnlineExaminationSystem.bean.WrongTitle;
import com.zlb.OnlineExaminationSystem.mapper.WrongTitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WrongTitleService implements WrongTitleMapper {

    @Autowired
    WrongTitleMapper wrongTitleMapper;

    @Override
    public int InsertWrongTitle(WrongTitle wrongTitle) {
        return wrongTitleMapper.InsertWrongTitle(wrongTitle);
    }

    @Override
    public WrongTitle selectWrongTitle(WrongTitle wrongTitle) {
        return wrongTitleMapper.selectWrongTitle(wrongTitle);
    }

    @Override
    public ArrayList<WrongTitle> selectWrongTitleByUser_id(Integer user_id) {
        return wrongTitleMapper.selectWrongTitleByUser_id(user_id);
    }

    @Override
    public int DeldteWrongTitle(WrongTitle wrongTitle) {
        return wrongTitleMapper.DeldteWrongTitle(wrongTitle);
    }
}

