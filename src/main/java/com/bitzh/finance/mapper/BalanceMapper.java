package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.Balance;
import com.bitzh.finance.entity.BalanceExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BalanceMapper {
    long countByExample(BalanceExample example);

    int deleteByExample(BalanceExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Balance record);

    int insertSelective(Balance record);

    List<Balance> selectByExample(BalanceExample example);

    Balance selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Balance record, @Param("example") BalanceExample example);

    int updateByExample(@Param("record") Balance record, @Param("example") BalanceExample example);

    int updateByPrimaryKeySelective(Balance record);

    int updateByPrimaryKey(Balance record);

    List<Balance> selectByExampleWithUser(BalanceExample balanceExample);

    Integer Add(BigDecimal amount, Integer userId);

    Integer Sub(BigDecimal withdrawamount, Integer userId);

    Integer consume(Integer userId, BigDecimal monetary);
}