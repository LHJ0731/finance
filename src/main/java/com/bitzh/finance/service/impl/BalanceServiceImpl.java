package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.Balance;
import com.bitzh.finance.entity.BalanceExample;
import com.bitzh.finance.mapper.BalanceMapper;
import com.bitzh.finance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    BalanceMapper balanceMapper;

    @Autowired
    BalanceService balanceService;

    @Override
    public Balance selectBalanceByUserId(Integer userId) {
        Balance balance = balanceMapper.selectByPrimaryKey(userId);
        return balance;
    }

    @Override
    public synchronized Integer addByBankCard(BigDecimal amount, Integer userId) {
        return balanceService.realaddByBankCard(amount, userId);
    }

    @Override
    @Transactional
    public Integer realaddByBankCard(BigDecimal amount, Integer userId) {
        return balanceMapper.Add(amount, userId);
    }

    @Override
    @Transactional
    public Integer insertBalance(Balance balance) {
        return balanceMapper.insert(balance);
    }

}
