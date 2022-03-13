package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.FundProduct;
import com.bitzh.finance.entity.FundProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FundProductMapper {
    long countByExample(FundProductExample example);

    int deleteByExample(FundProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundProduct record);

    int insertSelective(FundProduct record);

    List<FundProduct> selectByExample(FundProductExample example);

    FundProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundProduct record, @Param("example") FundProductExample example);

    int updateByExample(@Param("record") FundProduct record, @Param("example") FundProductExample example);

    int updateByPrimaryKeySelective(FundProduct record);

    int updateByPrimaryKey(FundProduct record);

    List<FundProduct> selectFundProductByInfo(String information);

    Integer selectcount();
}