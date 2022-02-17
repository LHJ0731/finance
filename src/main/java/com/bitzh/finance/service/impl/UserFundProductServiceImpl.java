package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.UserFundProduct;
import com.bitzh.finance.entity.UserFundProductExample;
import com.bitzh.finance.mapper.UserFundProductMapper;
import com.bitzh.finance.service.UserFundProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserFundProductServiceImpl implements UserFundProductService {
    @Autowired
    UserFundProductMapper userFundProductMapper;

    @Override
    @Transactional
    public Integer insertUserFundProduct(UserFundProduct userFundProduct) {
        return userFundProductMapper.insertSelective(userFundProduct);
    }

    @Override
    public List<UserFundProduct> selectUserFundProductByUserId(Integer userId) {
        UserFundProductExample ufpe = new UserFundProductExample();
        ufpe.createCriteria().andUseridEqualTo(userId);
        return userFundProductMapper.selectByExampleWithUserAndFundProduct(ufpe);
    }

    @Override
    @Transactional
    public Integer updateUserFundProduct(UserFundProduct userFundProduct) {
        return userFundProductMapper.updateByPrimaryKeySelective(userFundProduct);
    }

    @Override
    public UserFundProduct selectUserFundProductById(Integer id) {
        return userFundProductMapper.selectByPrimaryKeyWithUserAndFundProduct(id);
    }
}
