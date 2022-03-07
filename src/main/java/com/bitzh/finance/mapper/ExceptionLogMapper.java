package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.ExceptionLog;
import com.bitzh.finance.entity.ExceptionLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ExceptionLogMapper {
    long countByExample(ExceptionLogExample example);

    int deleteByExample(ExceptionLogExample example);

    int deleteByPrimaryKey(String excId);

    int insert(ExceptionLog record);

    int insertSelective(ExceptionLog record);

    List<ExceptionLog> selectByExampleWithBLOBs(ExceptionLogExample example);

    List<ExceptionLog> selectByExample(ExceptionLogExample example);

    ExceptionLog selectByPrimaryKey(String excId);

    int updateByExampleSelective(@Param("record") ExceptionLog record, @Param("example") ExceptionLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ExceptionLog record, @Param("example") ExceptionLogExample example);

    int updateByExample(@Param("record") ExceptionLog record, @Param("example") ExceptionLogExample example);

    int updateByPrimaryKeySelective(ExceptionLog record);

    int updateByPrimaryKeyWithBLOBs(ExceptionLog record);

    int updateByPrimaryKey(ExceptionLog record);
}