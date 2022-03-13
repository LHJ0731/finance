package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.Permissions;
import com.bitzh.finance.entity.PermissionsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionsMapper {
    long countByExample(PermissionsExample example);

    int deleteByExample(PermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    List<Permissions> selectByExample(PermissionsExample example);

    Permissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permissions record, @Param("example") PermissionsExample example);

    int updateByExample(@Param("record") Permissions record, @Param("example") PermissionsExample example);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
}