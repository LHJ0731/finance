package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.FlowOfFunds;
import com.bitzh.finance.entity.FlowOfFundsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowOfFundsMapper {
    long countByExample(FlowOfFundsExample example);

    int deleteByExample(FlowOfFundsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowOfFunds record);

    int insertSelective(FlowOfFunds record);

    List<FlowOfFunds> selectByExample(FlowOfFundsExample example);

    FlowOfFunds selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowOfFunds record, @Param("example") FlowOfFundsExample example);

    int updateByExample(@Param("record") FlowOfFunds record, @Param("example") FlowOfFundsExample example);

    int updateByPrimaryKeySelective(FlowOfFunds record);

    int updateByPrimaryKey(FlowOfFunds record);
}