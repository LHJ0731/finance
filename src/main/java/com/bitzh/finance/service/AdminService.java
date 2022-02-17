package com.bitzh.finance.service;

import com.bitzh.finance.entity.Admin;

public interface AdminService {

    Admin selectAdminByTerms(String username, String password);

    Integer updateAdmin(Admin admin);

    Admin selectAdminById(Integer id);
}
