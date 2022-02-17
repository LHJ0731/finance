package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.TermFinancial;
import com.bitzh.finance.entity.TermFinancialExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TermFinancialMapper {
    long countByExample(TermFinancialExample example);

    int deleteByExample(TermFinancialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TermFinancial record);

    int insertSelective(TermFinancial record);

    List<TermFinancial> selectByExample(TermFinancialExample example);

    TermFinancial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TermFinancial record, @Param("example") TermFinancialExample example);

    int updateByExample(@Param("record") TermFinancial record, @Param("example") TermFinancialExample example);

    int updateByPrimaryKeySelective(TermFinancial record);

    int updateByPrimaryKey(TermFinancial record);

    List<TermFinancial> selectTermFinancialByInfo(String information);
}