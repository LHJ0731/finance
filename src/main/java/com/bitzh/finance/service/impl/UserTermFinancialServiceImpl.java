package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.UserTermFinancial;
import com.bitzh.finance.entity.UserTermFinancialExample;
import com.bitzh.finance.mapper.UserTermFinancialMapper;
import com.bitzh.finance.service.UserTermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserTermFinancialServiceImpl implements UserTermFinancialService {
    @Autowired
    UserTermFinancialMapper userTermFinancialMapper;

    @Override
    @Transactional
    public Integer insertUserTermFinancial(UserTermFinancial userTermFinancial) {
        return userTermFinancialMapper.insertSelective(userTermFinancial);
    }

    @Override
    public List<UserTermFinancial> selectUserTermFinancialByUserId(Integer userId) {
        UserTermFinancialExample utfe = new UserTermFinancialExample();
        utfe.createCriteria().andUseridEqualTo(userId);
        return userTermFinancialMapper.selectByExampleWithUserAndTermFinancial(utfe);
    }

    @Override
    @Transactional
    public Integer updateUserTermFinancial(UserTermFinancial userTermFinancial) {
        return userTermFinancialMapper.updateByPrimaryKeySelective(userTermFinancial);
    }

    @Override
    public UserTermFinancial selectUserTermFinancialById(Integer id) {
        return userTermFinancialMapper.selectByPrimaryKeyWithUserAndTermFinancial(id);
    }
}
