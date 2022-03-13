package com.bitzh.finance.service;

import com.bitzh.finance.entity.OperationLog;

import java.util.List;

public interface OperationLogService {
    Integer insert(OperationLog operlog);

    List<OperationLog> selectAllOperationLog();

    Integer deleteOperationLogById(String id);
}
