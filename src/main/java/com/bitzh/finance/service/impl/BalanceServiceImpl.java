package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.Balance;
import com.bitzh.finance.mapper.BalanceMapper;
import com.bitzh.finance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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

    @Override
    public synchronized Integer withdrawToBankCard(BigDecimal amount, Integer userId) {
        return balanceService.realwithdrawToBankCard(amount, userId);
    }

    @Override
    @Transactional
    public Integer realwithdrawToBankCard(BigDecimal withdrawamount, Integer userId) {
        return balanceMapper.Sub(withdrawamount, userId);
    }

    @Override
    public synchronized Integer consume(Integer userId, BigDecimal monetary) {
        return balanceService.realconsume(userId, monetary);
    }

    @Override
    @Transactional
    public Integer realconsume(Integer userId, BigDecimal monetary) {
        return balanceMapper.consume(userId, monetary);
    }

    @Override
    public synchronized Integer income(Integer userId, BigDecimal monetary) {
        return balanceService.realincome(userId, monetary);
    }

    @Override
    @Transactional
    public Integer realincome(Integer userId, BigDecimal monetary) {
        return balanceMapper.Add(monetary, userId);
    }
}
