package com.bitzh.finance.mapper;

import com.bitzh.finance.entity.AdminPermissions;
import com.bitzh.finance.entity.AdminPermissionsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminPermissionsMapper {
    long countByExample(AdminPermissionsExample example);

    int deleteByExample(AdminPermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminPermissions record);

    int insertSelective(AdminPermissions record);

    List<AdminPermissions> selectByExample(AdminPermissionsExample example);

    AdminPermissions selectByPrimaryKey(Integer id);

    List<AdminPermissions> selectByExampleWithAdminAndPermissions(AdminPermissionsExample example);

    AdminPermissions selectByPrimaryKeyWithAdminAndPermissions(Integer id);

    int updateByExampleSelective(@Param("record") AdminPermissions record, @Param("example") AdminPermissionsExample example);

    int updateByExample(@Param("record") AdminPermissions record, @Param("example") AdminPermissionsExample example);

    int updateByPrimaryKeySelective(AdminPermissions record);

    int updateByPrimaryKey(AdminPermissions record);
}