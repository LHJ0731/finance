package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.PayMoney;
import com.bitzh.finance.entity.PayMoneyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayMoneyMapper {
    long countByExample(PayMoneyExample example);

    int deleteByExample(PayMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayMoney record);

    int insertSelective(PayMoney record);

    List<PayMoney> selectByExample(PayMoneyExample example);

    PayMoney selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayMoney record, @Param("example") PayMoneyExample example);

    int updateByExample(@Param("record") PayMoney record, @Param("example") PayMoneyExample example);

    int updateByPrimaryKeySelective(PayMoney record);

    int updateByPrimaryKey(PayMoney record);

    List<PayMoney> selectPayMoneyByInfo(String information);

    Integer selectcount();
}