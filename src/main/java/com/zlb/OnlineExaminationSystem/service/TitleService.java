package com.zlb.OnlineExaminationSystem.service;

import com.zlb.OnlineExaminationSystem.bean.Title;
import com.zlb.OnlineExaminationSystem.mapper.TitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TitleService implements TitleMapper {

    @Autowired
    TitleMapper titleMapper;

    @Override
    public int insertTitle(Title title) {
        return titleMapper.insertTitle(title);
    }

    @Override
    public int deleteByTitle_id(Integer title_id) {
        return titleMapper.deleteByTitle_id(title_id);
    }

    @Override
    public Title selectByTitle_id(Integer title_id) {
        return titleMapper.selectByTitle_id(title_id);
    }

    @Override
    public ArrayList<Title> selectAllTitle() {
        return titleMapper.selectAllTitle();
    }

    @Override
    public ArrayList<Title> selectRandomTitle(Integer number) {
        return titleMapper.selectRandomTitle(number);
    }

    @Override
    public int updateTitle(Title title) {
        return titleMapper.updateTitle(title);
    }
}
