package com.bitzh.finance.service;

import com.bitzh.finance.entity.Balance;

import java.util.List;

public interface BalanceService {
    Balance selectBalanceByUserId(Integer id);
}
