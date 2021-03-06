package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.UserPayMoney;
import com.bitzh.finance.entity.UserPayMoneyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPayMoneyMapper {
    long countByExample(UserPayMoneyExample example);

    int deleteByExample(UserPayMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPayMoney record);

    int insertSelective(UserPayMoney record);

    List<UserPayMoney> selectByExample(UserPayMoneyExample example);

    UserPayMoney selectByPrimaryKey(Integer id);

    List<UserPayMoney> selectByExampleWithUserAndPayMoney(UserPayMoneyExample example);

    UserPayMoney selectByPrimaryKeyWithUserAndPayMoney(Integer id);

    int updateByExampleSelective(@Param("record") UserPayMoney record, @Param("example") UserPayMoneyExample example);

    int updateByExample(@Param("record") UserPayMoney record, @Param("example") UserPayMoneyExample example);

    int updateByPrimaryKeySelective(UserPayMoney record);

    int updateByPrimaryKey(UserPayMoney record);
}