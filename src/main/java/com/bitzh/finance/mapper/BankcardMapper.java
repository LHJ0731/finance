package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.Bankcard;
import com.bitzh.finance.entity.BankcardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankcardMapper {
    long countByExample(BankcardExample example);

    int deleteByExample(BankcardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bankcard record);

    int insertSelective(Bankcard record);

    List<Bankcard> selectByExample(BankcardExample example);

    Bankcard selectByPrimaryKey(Integer id);

    List<Bankcard> selectByExampleWithUser(BankcardExample example);

    Bankcard selectByPrimaryKeyWithUser(Integer id);

    int updateByExampleSelective(@Param("record") Bankcard record, @Param("example") BankcardExample example);

    int updateByExample(@Param("record") Bankcard record, @Param("example") BankcardExample example);

    int updateByPrimaryKeySelective(Bankcard record);

    int updateByPrimaryKey(Bankcard record);
}