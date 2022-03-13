package com.bitzh.finance.service;

import com.bitzh.finance.entity.PayMoney;

import java.util.List;

public interface PayMoneyService {

    List<PayMoney> selectAllPayMoney();

    PayMoney selectPayMoneyById(Integer id);

    Integer insertPayMoney(PayMoney payMoney);

    Integer updatePayMoney(PayMoney payMoney);

    Integer deletePayMoneyById(Integer id);

    List<PayMoney> selectPayMoneyByInfo(String information);

    Integer selectcount();
}
