package com.bitzh.finance.service;

import com.bitzh.finance.entity.Balance;

import java.math.BigDecimal;

public interface BalanceService {
    Balance selectBalanceByUserId(Integer id);

    Integer addByBankCard(BigDecimal amount, Integer userId);

    Integer realaddByBankCard(BigDecimal amount, Integer userId);

    Integer insertBalance(Balance balance);

    Integer withdrawToBankCard(BigDecimal withdrawamount, Integer userId);

    Integer realwithdrawToBankCard(BigDecimal withdrawamount, Integer userId);

    Integer consume(Integer userId, BigDecimal monetary);

    Integer realconsume(Integer userId, BigDecimal monetary);

    Integer income(Integer userId, BigDecimal monetary);

    Integer realincome(Integer userId, BigDecimal monetary);
}
