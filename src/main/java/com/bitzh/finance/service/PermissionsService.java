package com.bitzh.finance.service;

import com.bitzh.finance.entity.Permissions;

import java.util.List;

public interface PermissionsService {

    List<Permissions> selectPermissionsByPermission(String permission);
}
