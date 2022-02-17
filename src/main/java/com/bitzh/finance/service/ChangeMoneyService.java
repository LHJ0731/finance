package com.bitzh.finance.service;

import com.bitzh.finance.entity.ChangeMoney;

import java.util.List;

public interface ChangeMoneyService {

    List<ChangeMoney> selectAllChangeMoney();

    ChangeMoney selectChangeMoneyById(Integer id);

    Integer insertChangeMoney(ChangeMoney changeMoney);

    Integer updateChangeMoney(ChangeMoney changeMoney);

    Integer deleteChangeMoneyById(Integer id);

    List<ChangeMoney> selectChangeMoneyByInfo(String information);
}
