package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.Info;
import com.bitzh.finance.entity.InfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {
    long countByExample(InfoExample example);

    int deleteByExample(InfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(Integer id);

    List<Info> selectByExampleWithUserAndAdmin(InfoExample example);

    Info selectByPrimaryKeyWithUserAndAdmin(Integer id);

    int updateByExampleSelective(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByExample(@Param("record") Info record, @Param("example") InfoExample example);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}