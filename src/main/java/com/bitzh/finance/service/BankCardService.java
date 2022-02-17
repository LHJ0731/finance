package com.bitzh.finance.service;

import com.bitzh.finance.entity.Bankcard;

import java.util.List;

public interface BankCardService {

    List<Bankcard> selectAllBankCard();

    List<Bankcard> selectBankCardByUserId(Integer userId);

    Bankcard selectBankCardById(Integer id);

    Integer insertBankCard(Bankcard bankcard);

    Integer updateBankCard(Bankcard bankcard);

    Integer deleteBankCardById(Integer id);
}
