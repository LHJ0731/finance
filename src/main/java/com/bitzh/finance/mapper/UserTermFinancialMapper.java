package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.UserTermFinancial;
import com.bitzh.finance.entity.UserTermFinancialExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTermFinancialMapper {
    long countByExample(UserTermFinancialExample example);

    int deleteByExample(UserTermFinancialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTermFinancial record);

    int insertSelective(UserTermFinancial record);

    List<UserTermFinancial> selectByExample(UserTermFinancialExample example);

    UserTermFinancial selectByPrimaryKey(Integer id);

    List<UserTermFinancial> selectByExampleWithUserAndTermFinancial(UserTermFinancialExample example);

    UserTermFinancial selectByPrimaryKeyWithUserAndTermFinancial(Integer id);

    int updateByExampleSelective(@Param("record") UserTermFinancial record, @Param("example") UserTermFinancialExample example);

    int updateByExample(@Param("record") UserTermFinancial record, @Param("example") UserTermFinancialExample example);

    int updateByPrimaryKeySelective(UserTermFinancial record);

    int updateByPrimaryKey(UserTermFinancial record);
}