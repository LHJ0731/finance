package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.UserFundProduct;
import com.bitzh.finance.entity.UserFundProductExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFundProductMapper {
    long countByExample(UserFundProductExample example);

    int deleteByExample(UserFundProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFundProduct record);

    int insertSelective(UserFundProduct record);

    List<UserFundProduct> selectByExample(UserFundProductExample example);

    UserFundProduct selectByPrimaryKey(Integer id);

    List<UserFundProduct> selectByExampleWithUserAndFundProduct(UserFundProductExample example);

    UserFundProduct selectByPrimaryKeyWithUserAndFundProduct(Integer id);

    int updateByExampleSelective(@Param("record") UserFundProduct record, @Param("example") UserFundProductExample example);

    int updateByExample(@Param("record") UserFundProduct record, @Param("example") UserFundProductExample example);

    int updateByPrimaryKeySelective(UserFundProduct record);

    int updateByPrimaryKey(UserFundProduct record);
}