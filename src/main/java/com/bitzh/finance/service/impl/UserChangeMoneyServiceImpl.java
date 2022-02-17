package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.UserChangeMoney;
import com.bitzh.finance.entity.UserChangeMoneyExample;
import com.bitzh.finance.mapper.UserChangeMoneyMapper;
import com.bitzh.finance.service.UserChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserChangeMoneyServiceImpl implements UserChangeMoneyService {
    @Autowired
    UserChangeMoneyMapper userChangeMoneyMapper;

    @Override
    @Transactional
    public Integer insertUserChangeMoney(UserChangeMoney userChangeMoney) {
        int result = userChangeMoneyMapper.insertSelective(userChangeMoney);
        return result;
    }

    @Override
    public List<UserChangeMoney> selectUserChangeMoneyByUserId(Integer userId) {
        UserChangeMoneyExample ucme = new UserChangeMoneyExample();
        ucme.createCriteria().andUseridEqualTo(userId);
        return userChangeMoneyMapper.selectByExampleWithUserAndChangeMoney(ucme);
    }

    @Override
    @Transactional
    public Integer updateUserChangeMoney(UserChangeMoney userChangeMoney) {
        return userChangeMoneyMapper.updateByPrimaryKeySelective(userChangeMoney);
    }

    @Override
    public UserChangeMoney selectUserChangeMoneyById(Integer id) {
        return userChangeMoneyMapper.selectByPrimaryKeyWithUserAndChangeMoney(id);
    }
}
