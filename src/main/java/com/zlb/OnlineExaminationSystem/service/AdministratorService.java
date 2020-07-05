package com.zlb.OnlineExaminationSystem.service;

import com.zlb.OnlineExaminationSystem.bean.Administrator;
import com.zlb.OnlineExaminationSystem.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService implements AdministratorMapper {

    @Autowired
    AdministratorMapper administratorMapper;

    @Override
    public int insertAdministrator(Administrator administrator) {
        return administratorMapper.insertAdministrator(administrator);
    }

    @Override
    public int deleteByAdministrator_id(Integer administrator_id) {
        return administratorMapper.deleteByAdministrator_id(administrator_id);
    }

    @Override
    public int updateAdministrator(Administrator administrator) {
        return updateAdministrator(administrator);
    }

    @Override
    public Administrator selectAdministrator(Integer administrator_id) {
        return administratorMapper.selectAdministrator(administrator_id);
    }
}
