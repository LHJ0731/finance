package com.bitzh.finance.entity;

import com.bitzh.finance.entity.Admin;
import com.bitzh.finance.entity.Permissions;

public class AdminPermissions {
    private Integer id;

    private Integer adminid;

    private com.bitzh.finance.entity.Admin admin;

    private Integer permissionid;

    private com.bitzh.finance.entity.Permissions permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public com.bitzh.finance.entity.Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public com.bitzh.finance.entity.Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }
}