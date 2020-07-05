package com.zlb.OnlineExaminationSystem.service;


import com.zlb.OnlineExaminationSystem.bean.Results;
import com.zlb.OnlineExaminationSystem.mapper.ResultsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ResultsService implements ResultsMapper {

    @Autowired
    ResultsMapper resultsMapper;

    @Override
    public int deleteResultByResults_id(Integer results_id) {
        return resultsMapper.deleteResultByResults_id(results_id);
    }

    @Override
    public int insertResults(Results results) {
        return resultsMapper.insertResults(results);
    }

    @Override
    public int deleteResultByTitle_id(Integer title_id) {
        return resultsMapper.deleteResultByTitle_id(title_id);
    }

    @Override
    public ArrayList<Results> selectResultByTitle_id(Integer title_id) {
        return resultsMapper.selectResultByTitle_id(title_id);
    }

    @Override
    public int updateResults(Results results) {
        return resultsMapper.updateResults(results);
    }
}
