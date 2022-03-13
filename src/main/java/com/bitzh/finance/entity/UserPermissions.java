package com.bitzh.finance.entity;

public class UserPermissions {
    private Integer id;

    private Integer userid;

    private com.bitzh.finance.entity.User user;

    private Integer permissionid;

    private com.bitzh.finance.entity.Permissions permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public com.bitzh.finance.entity.User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public com.bitzh.finance.entity.Permissions getPermissions() {
        return permissions;
    }

    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }
}