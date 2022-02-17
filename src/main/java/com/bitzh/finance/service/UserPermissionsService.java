package com.bitzh.finance.service;

import com.bitzh.finance.entity.UserPermissions;

import java.util.List;

public interface UserPermissionsService {

    List<UserPermissions> selectUserPermissionsByUserId(Integer userId);

    UserPermissions selectUserPermissionsByPermissionId(Integer permissionId);

    Integer insertUserPermissions(UserPermissions userPermissions);

    Integer UpdateUserPermissions(UserPermissions userPermissions);

    Integer deleteUserPermissionsByPermissionId(Integer permissionId);

    Integer deleteAllUserPermissionsByUserId(Integer userId);
}
