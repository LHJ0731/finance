package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.UserChangeMoney;
import com.bitzh.finance.entity.UserChangeMoneyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserChangeMoneyMapper {

    long countByExample(UserChangeMoneyExample example);

    int deleteByExample(UserChangeMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserChangeMoney record);

    int insertSelective(UserChangeMoney record);

    List<UserChangeMoney> selectByExample(UserChangeMoneyExample example);

    UserChangeMoney selectByPrimaryKey(Integer id);

    List<UserChangeMoney> selectByExampleWithUserAndChangeMoney(UserChangeMoneyExample example);

    UserChangeMoney selectByPrimaryKeyWithUserAndChangeMoney(Integer id);

    int updateByExampleSelective(@Param("record") UserChangeMoney record, @Param("example") UserChangeMoneyExample example);

    int updateByExample(@Param("record") UserChangeMoney record, @Param("example") UserChangeMoneyExample example);

    int updateByPrimaryKeySelective(UserChangeMoney record);

    int updateByPrimaryKey(UserChangeMoney record);
}