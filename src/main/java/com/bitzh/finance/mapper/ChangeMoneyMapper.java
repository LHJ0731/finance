package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.ChangeMoney;
import com.bitzh.finance.entity.ChangeMoneyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChangeMoneyMapper {
    long countByExample(ChangeMoneyExample example);

    int deleteByExample(ChangeMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChangeMoney record);

    int insertSelective(ChangeMoney record);

    List<ChangeMoney> selectByExample(ChangeMoneyExample example);

    ChangeMoney selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChangeMoney record, @Param("example") ChangeMoneyExample example);

    int updateByExample(@Param("record") ChangeMoney record, @Param("example") ChangeMoneyExample example);

    int updateByPrimaryKeySelective(ChangeMoney record);

    int updateByPrimaryKey(ChangeMoney record);

    List<ChangeMoney> selectChangeMoneyByInfo(String information);

    Integer selectcount();
}